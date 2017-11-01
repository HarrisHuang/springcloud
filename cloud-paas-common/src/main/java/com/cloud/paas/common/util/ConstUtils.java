package com.cloud.paas.common.util;

/**
 * @ClassName: Const
 * @Package com.accenture.javis.common.base
 * @Description: 本系统中的所有常量
 * @author zhengwei.bu
 * @date 2014年2月25日 下午5:29:37
 */
public class ConstUtils {

	/**
	 * 账号ID
	 */
	public static final String SESSION_ACCOUNT_ID="accountId";
	/**
	 * 账号名
	 */
	public static final String SESSION_ACCOUNT_NAME="accountName";
	/**
	 * @Fields SESSION_USER_ID : session中存放当前登录用户ID的标识
	 */
	public static final String SESSION_USER_ID="userId";
	
	/**
	 * @Fields SESSION_USER_NAME : session中存放当前登录用户姓名的标识
	 */
	public static final String SESSION_USER_NAME="userName";
	
	/**
	 * @Fields SESSION_ORGAN_ID : session中存放当前登录用户所属组织ID的标识
	 */
	public static final String SESSION_ORGAN_ID="organId";
	
	/**
	 * @Fields SESSION_ORGAN_ID : session中存放当前登录用户所属组织ID的名称
	 */
	public static final String SESSION_ORGAN_NAME="organName";
	
	/**
	 * @Fields SESSION_ROLE_ID : session中存放当前登录用户对应的所有角色ID的标识
	 */
	public static final String SESSION_ROLE_ID_LIST="roleIdList";
	
	/**
	 * 登陆入口：1,内部门户；2，外部门户；3，党建平台；4，系统管理，5，手机APP
	 */
	public static final String SESSION_LOGIN_ENTRANCE="loginEntrance";
	/**
	 * 头像
	 */
	public static final String SESSION_AVATAR = "avatar";
	
	/**
	 * 显示壳
	 */
	public static final String VIEW_SHELL="viewShell";
	
	/**
	 * @Fields ERROR_SYSTEM_TIMEOUT :错误代码，系统超时
	 */
	public static final String  ERROR_SYSTEM_TIMEOUT="1";

	/**
	 * @Fields ERROR_NO_PERMISSION :错误代码，无权限访问
	 */
	public static final String  ERROR_NO_PERMISSION="2";
	
	/**
	 * @Fields ERROR_SYSTEM_EXCEPTION :错误代码，系统异常（服务器错误）
	 */
	public static final String  ERROR_SYSTEM_EXCEPTION="3";
	
	
	/**   
	 * @Fields: ENABLE   
	 * @Todo: TODO  通用开启变量
	 */ 
	public static final String ENABLE = "1";
	
	/**   
	 * @Fields: DISABLE  
	 * @Todo: TODO  通用关闭变量
	 */ 
	public static final String DISABLE = "0";
	
	/**
	 * 组织树，节点为叶子节点时的取值
	 */
	public static final String WORK_ORG_TREE_IS_LEAF_TRUE = "1";
	
	/**
	 * 节点定义类型：会签
	 */
	public static final String BPM_TASK_DEFINITION_TYPE_SIGN = "SIGN";
	/**
	 * 节点定义类型：普通
	 */
	public static final String BPM_TASK_DEFINITION_TYPE_NORMAL = "NORMAL";
	
	/**
	 * 节点定义类型：开始事件
	 */
	public static final String BPM_TASK_DEFINITION_TYPE_START = "START";
	/**
	 * 节点定义类型：结束事件
	 */
	public static final String BPM_TASK_DEFINITION_TYPE_END = "END";
	
	
	/**   
	 * @Fields: default_encrypt_algorithm  
	 * @Todo: 默认加密算法  
	 */ 
	public static final String DEFAULT_ENCRYPT_ALGORITHM = "MD5_TWICE";
	
	/**
	 * 默认密码
	 */
	public static final String DEFAULT_PASSWORD = "123456";
	/**
	 * 盐值（扰乱码）
	 */
	public static final String SALT_VALUE = "123456";
	
	/**
	 * 手机APP通知消息队列，
	 */
	public static final String APP_MESSAGE_QUEUE = "APP_MESSAGE_QUEUE";
	/**
	 * 手机APP即时通讯消息队列
	 */
	public static final String APP_INSTANT_MESSAGING_QUEUE = "APP_INSTANT_MESSAGING_QUEUE";
	
	/**
	 * 短信队列
	 */
	public static final String SMS_QUEUE = "SMS_QUEUE";
	
	/**
	 * 别名类型  userId
	 */
	public static final String MESSAGE_ALIAS_TYPE_USER_ID = "userId";
	
	/**
	 * 别名类型orgId
	 */
	public static final String MESSAGE_ALIAS_TYPE_ORG_ID= "orgId";
	
	
	/**
	 * 别名类型 saas 系统发送
	 */
	public static final String MESSAGE_ALIAS_TYPE_SYSTEM_SERVICE= "systemService";
	
	
	/**
	 * 消息类型：新增消息
	 */
	public static final String MQ_MESSAGE_OPERATION_ADD = "add";
	/**
	 * 消息类型：删除消息
	 */
	public static final String MQ_MESSAGE_OPERATION_DELETE = "delete";
	
	/**
	 * 任意设备
	 */
	public static final String ANY_CLIENT_DEVICE = "*";
	
	
	/**   
	 * @Fields: BPM_FIX_PARTICIPANID_FOR_CREATOR_ORGAN  
	 * @Todo: 创建人组织的固定ID  
	 */ 
	public static final String BPM_FIX_PARTICIPANID_FOR_CREATOR_ORGAN = "bpmFixParticipanidForCreatorOrgan";
	
	/**   
	 * @Fields: BPM_FIX_PARTICIPANID_FOR_CURRENT_ORGAN  
	 * @Todo: 当前组织的固定ID   
	 */ 
	public static final String BPM_FIX_PARTICIPANID_FOR_CURRENT_ORGAN = "bpmFixParticipanidForCurrentOrganv1";
}
