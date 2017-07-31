package com.lyw.action;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.bwf.utils.PagingUtils;
import com.lyw.dao.DepartDAO;
import com.lyw.dao.UserDAO;
import com.lyw.entity.Depart;
import com.lyw.entity.Users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport implements ModelDriven<Users>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PagingUtils pagingUtils=new PagingUtils();
	
    private File image; //上传的文件
    
    private String imageFileName; //文件名称
    
    private String imageContentType; //文件类型

	private int departId;
		
	private List<Users> userList;
	
	private Users user = new Users();
	/**
	 * 用于将所有人员显示出来
	 * @return
	 */
	public String showAll(){
		UserDAO dao = new UserDAO();
		setUserList(dao.selectAll());
		return "showAll";
	}
	/**
	 * 用于在添加用户界面显示部门
	 * @return
	 */
	public String addUser(){
		DepartDAO dao = new DepartDAO();
		List<Depart> departList = dao.selectAll();
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("departList", departList);
		return "addUser";
	}
	/**
	 * 用于展示所有用户
	 * @return
	 */
	public String userManage(){
		UserDAO userDAO = new UserDAO();
		userDAO.QueryByPage(pagingUtils);
		userList=pagingUtils.getUserList();
		return "manage";
	}
	/**
	 * 用于添加employee
	 * @return
	 */
	public String insert(){	
		UserDAO userDAO = new UserDAO();
		Timestamp addTime = new Timestamp(System.currentTimeMillis());
		addTime.setNanos(0);
		user.setAddTime(addTime);
		String realPath = ServletActionContext.getServletContext().getRealPath("/images");
		String photo = System.currentTimeMillis()+"RD"+(Math.random())+imageFileName.substring(imageFileName.lastIndexOf('.'));
		user.setPhoto(photo);
		user.setDepart(new DepartDAO().selectById(departId));
		userDAO.insert(user);
		//数据库操作成功后再添加图片
		try {
			FileUtils.copyFile(image, new File(realPath+"/"+photo));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "insert";
	}
	/**
	 * 用于修改某一用户时，显示用户信息
	 * @return
	 */
	public String findUser(){
		UserDAO dao = new UserDAO();
		user=dao.selectById(user.getId());
		DepartDAO departDAO = new DepartDAO();
		List<Depart> departList = departDAO.selectAll();
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("departList", departList);
		vs.set("userOld", user);
		return "modify";
	}
	/**
	 * 用于更新员工信息使用
	 * @return
	 */
	public String update(){
		UserDAO dao = new UserDAO();
		Users userOld = dao.selectById(user.getId());
		//获取原图片路径，用于后期替代图片使用
		String realPath = ServletActionContext.getServletContext().getRealPath("/images");
		String photo=userOld.getPhoto();
		if(("".equals(photo)||photo==null)&&image!=null)
			photo = System.currentTimeMillis()+"RD"+(Math.random())+imageFileName.substring(imageFileName.lastIndexOf('.'));
		user.setPhoto(photo);
		user.setAddTime(userOld.getAddTime());
		user.setDepart(new DepartDAO().selectById(departId));
		dao.update(user);
		try {
			if(image!=null){
				FileUtils.copyFile(image, new File(realPath+"/"+photo));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "update";
	}
	
	/**
	 * 删除方法
	 * @return
	 */
	public String deleteUser(){
		UserDAO dao = new UserDAO();
		user = dao.selectById(user.getId());
		if(user.getPhoto()!=null&&!"".equals(user.getPhoto())){
			String photo=user.getPhoto();
			String realPath=ServletActionContext.getServletContext().getRealPath("/images");
			File file = new File(realPath+"/"+photo);
			file.delete();
		}
		dao.deletById(user);
		return "delete";
	}
	public String queryByPage(){
		UserDAO userDAO = new UserDAO();
		userDAO.QueryByPage(pagingUtils);
		userList=pagingUtils.getUserList();
		return "page";
	}
	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}

	@Override
	public Users getModel() {
		return user;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	public int getDepartId() {
		return departId;
	}
	public void setDepartId(int departId) {
		this.departId = departId;
	}
	public PagingUtils getPagingUtils() {
		return pagingUtils;
	}
	public void setPagingUtils(PagingUtils pagingUtils) {
		this.pagingUtils = pagingUtils;
	}
}
