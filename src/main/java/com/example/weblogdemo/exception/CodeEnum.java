package com.example.weblogdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
* @author Xbin
* @description 业务异常的枚举类型
* @date 2021-10-13 14:48
* @email liuhongbindeemail@gmail.com
*/
@Getter
@AllArgsConstructor
public enum CodeEnum implements BusinessExceptionAssert{

    /**
     * 请求成功
     */
    SUCCESS(200, "成功"),

    success_code_sms(200,"短信验证码发送成功"),

    success_logout(200,"注销登录成功"),

    success_code_email(200,"邮箱验证码发送成功"),

    success_login(200,"登录成功"),

    success_register(200,"注册成功"),

    success_institution_register(200,"注册申请已成功提交"),

    success_update_password(200,"修改密码成功"),

    /**
     * 参数异常
     */
    FAILED(400, "参数异常"),

    failed_request_method_failed(403,"请求方法错误"),

    // 有使用
    failed_parameter_wrong(40001,"参数异常"),

    failed_user_not_found(40002, "用户不存在"),

    failed_phone_number_wrong(40003, "手机号码或密码输入错误"),

    failed_email_wrong(40004,"邮箱或密码输入错误"),

    failed_email_has_register(40005, "邮箱已注册"),

    failed_third_system_verify(40006,"滑动验证失败"),

    failed_phone_has_register(40007, "手机号已注册"),

    failed_code_overtime(40008,"验证码过期,请重新获取"),

    failed_code_wrong(40009,"验证码错误"),

    failed_username_has_register(40010,"用户名已注册"),

    failed_phone_number(40011,"手机号码错误"),

    failed_sms_wrong(40012,"短信发送失败"),

    failed_email_not_found(40013,"邮箱错误"),

    failed_email_or_password_wrong(40014,"邮箱或密码输入错误"),

    failed_user_frozen(40015,"账号已被冻结"),

    failed_register_has_push(40016,"信用注册号申请已经提交过，请勿重复提交申请"),

    failed_company_name_has_register(40017,"贵企业已注册，请勿重复提交"),

    failed_department_has_register(40017,"贵学院已注册，请勿重复提交"),

    failed_training__has_register(40018,"贵机构已注册，请勿重复提交"),

    failed_username_or_password_wrong(40019,"用户名或密码输入错误"),

    failed_add_user_exist(40020,"注册时，该邮箱/手机已存在"),

    failed_institution_not_exist(40021,"该机构账号未找到"),

    failed_institution_has_been_audited(40022,"该机构已审核"),

    failed_institution_fail_to_audit(40023,"该机构审核失败"),

    failed_load_file(40024,"文件读取失败"),

    failed_institution_is_invalid(40025,"该机构账号被禁用"),

    failed_init_table(40026,"表格有非法项"),

    failed_token(40027,"token异常"),

    failed_file_upload(40028,"上传的文件不符合要求"),

    failed_file_siez_over(40029,"上传文件不能超过10MB"),

    failed_audit_invalid(40030,"Audit非法"),

    failed_select_fail(40031,"未查询到相关信息"),

    failed_no_enable_password_login(40032,"未开启密码登录功能"),

    failed_company_name_no_null(40032,"公司名字不能为空"),

    failed_user_has_perfected_information(40033,"用户已完善信息"),

    failed_perfected_information_before_logo(40034,"完善信息前请先上传logo"),

    failed_update_logo_permission(40035,"非管理不可上传logo"),

    failed_login_outtime_permission(40035,"登录失效，请重新登录"),

    failed_insert_role(40036,"角色插入失败"),

    failed_upload_MQ(40037,"上传消息队列失败"),

    failed_deal_MQ_role(40038,"角色名不符合要求"),

    failed_send_mail(40039,"邮件发送异常"),

    failed_account(40040,"账号异常"),

    failed_email_not_register(40041, "未查询到用户邮箱或邮箱不匹配"),

    failed_phone_not_register(40042, "未查询到用户手机号或手机号不匹配"),

    failed_username_not_register(40043, "用户名未注册"),

    failed_stu_num_have_register(40044, "学号已存在"),

    failed_send_email_failed(40045, "邮件发送失败，请稍后重试"),

    failed_insert_train_experience(40046, "培训经历不完整"),

    failed_insert_educational_experience(40047, "教育经历不完整"),

    //failed_insert_interview(40048, "已发送过邀请"),
    failed_wrong_condition(40048, "筛选条件有误"),

    //failed_interview_rounds(40049,"请先安排面试"),
    failed_group_name_already_exist(40049, "群组名重复"),

    //failed_interview_failed(40050,"上一轮面试未完成"),
    failed_project_name_already_exist(40050, "项目名重复"),

    // failed_interview_register(40051,"面试已安排,请勿重复安排"),
    failed_delete_pole_type(40051, "删除灯杆类型"),

    //failed_interview_reinvite(40052,"重新邀请失败"),
    failed_no_lamp_pole_id(40052, "灯杆id为空"),

    // failed_send_user_message(40053,"发送站内消息失败"),
    failed_switch_pole(40054, "更换灯杆所属项目失败"),

    // failed_get_messageCount_from_redis(40054,"消息中心未读消息数获取失败"),
    failed_add_pole_to_project(40054, "项目添加灯杆失败"),

    // failed_interview_not_found(40055,"面试邀请不存在"),
    failed_add_pole_to_group(40055, "群组添加灯杆失败"),

    //failed_accept_interview(40056,"接受面试失败"),
    failed_remove_pole(40056, "群组移除灯杆失败"),

    // failed_cancel_interview(40057,"企业取消面试失败"),
    failed_user_no_login(40057, "用户未登录"),

    // failed_decline_interview(40058,"拒绝面试失败"),
    failed_no_pole_in_group(40058, "目标灯杆不存在"),

    //failed_interview_not_receiver(40059,"请等待对方接受邀请"),
    failed_no_group(40059, "群组不存在"),

    //failed_not_power(40060,"无权限操作"),
    failed_switch_group(40060, "灯杆更换群组失败"),

    // user_not_login(40061,"用户未登录"),
    failed_update_group_info(40062, "更新群组信息失败"),

    // failed_rating_interview(40062,"面试评分失败"),
    failed_delete_group(40062, "删除群组失败"),

    //failed_update_interview_result(40063,"评估面试结果失败"),
    failed_add_group(40063, "添加群组失败"),

    //failed_interview_time_is_the_past(40064,"该邀请已过期，请与联系人沟通更改面试时间"),
    failed_delete_job(40064, "scheduler删除job失败"),

    //failed_find_interview_round(40065,"查询不到此面试"),
    failed_delete_timer(40065, "scheduler删除定时规则失败"),

    // failed_interview_time_interview(40066,"面试时间是一个过期时间,请重新选择"),
    failed_pause_task(40066, "暂停任务失败"),

    // failed_position_time_past(40067,"期望入职时间已过期,请重新选择"),
    failed_add_task(40067, "启动任务失败"),

    failed_user_not_power(40068,"账号无权限"),

    // interviewee_already_accept_interview(40069,"操作失败，您已接受了面试邀请"),
    failed_task_not_exist(40069, "该任务不存在"),

    // interviewee_already_decline_interview(40079,"操作失败，您已拒绝了面试邀请"),
    failed_pole_type_already_exist(40069, "该灯杆型号已经存在"),

    // failed_interviewees_repeat(40099,"有重复面试官"),
    failed_upload_pole_image(40099, "上传灯杆图片失败"),

    // failed_project_experience_too_much(40100,"项目经历过多，请删除一些经历后再添加"),
    failed_pole_type_not_exist(40100,"目标灯杆类型不存在"),

    failed_project_not_exist(40101,"目标项目不存在"),

    failed_user_agent_error(40102, "请求头user-agent信息有误"),

    failed_department_already_exist(40103,"该部门已存在"),

    failed_sub_account_limit(40104,"数量已达限制，无法再注册新的子账号"),

    failed_switch_department(40105,"更换部门失败"),

    failed_param_should_be_json_form(40106,"请求参数应该是json形式"),

    failed_invalid_update_permission(40107,"当前权限修改操作不符合要求"),

    failed_target_department_not_exist(40108,"该部门不存在"),

    failed_can_not_delete_target_department(40109,"无法删除还有人员的部门"),

    failed_invalidate_sub_accounts(40110,"停用子账号失败"),

    failed_target_user_not_exist(40110,"目标用户不存在"),

    failed_department_not_exist(40111, "目标部门不存在"),

    failed_target_user_is_not_sub_account(40112,"目标账号不是子账号"),

    failed_email_is_null(40200,"邮箱未绑定,不需要解绑"),

    failed_phone_is_null(40201,"手机号码为空,不需要解绑"),

    failed_update_password_not_same(40202,"输入的旧密码错误"),

    failed_email_overtime(40203,"邮件过期，请重新获取"),

    failed_project_not_found(40204,"项目没找到，请刷新重试"),

    failed_lamp_type_not_found(40205,"灯杆类型没找到，请刷新重试"),

    failed_email_is_bind(40206,"邮箱已绑定，无需重复绑定"),

    failed_phone_is_bind(40207,"手机已绑定，无需重复绑定"),

    failed_phone_is_use(40208,"手机号已被绑定，不能重复使用,请更换手机号再绑定"),

    failed_email_is_use(40209,"邮箱已被绑定，不能重复使用,请更换邮箱再绑定"),
    /**
     * 系统异常
     */
    ERROR(500,"系统异常."),

    error_login(50001,"登录失败"),

    error_register(50002,"注册失败"),

    error_file_upload(50003,"文件上传失败，请稍后重试"),

    error_company_register(50004,"企业注册申请失败"),

    error_upload_institution(50005,"系统异常，获取表格失败")

    ;
    private int code;

    private String message;

    public CodeEnum setMessage(String message) {
        this.message = message;
        return this;
    }
}
