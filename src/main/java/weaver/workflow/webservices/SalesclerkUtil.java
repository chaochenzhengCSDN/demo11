package weaver.workflow.webservices;

import com.hodo.group2.hdcloud.employee.information.entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * 店员信息处理 创建店员流程
 * @author Administrator
 */
public class SalesclerkUtil {

    /**
     * 获取流程相关字段信息
     * @return
     * @throws Exception
     */
    public  WorkflowRequestInfo getWorkflowRequestInfo(String openId) throws Exception {

        //工作流程请求信息
        WorkflowRequestInfo workflowRequestInfo = new WorkflowRequestInfo();
        //显示
        workflowRequestInfo.setCanView(true);
        //可编辑
        workflowRequestInfo.setCanEdit(true);
        //请求标题
        workflowRequestInfo.setRequestName("工业互联-店员面试申请流程");
        //创建者ID 创建流程时为必输项
        workflowRequestInfo.setCreatorId("1");
        //工作流信息
        WorkflowBaseInfo workflowBaseInfo = new WorkflowBaseInfo();
        //流程ID
        workflowBaseInfo.setWorkflowId("102568");
        //工作流信息
        workflowRequestInfo.setWorkflowBaseInfo(workflowBaseInfo);

        /****************main table start*************/
        //主表
        WorkflowMainTableInfo workflowMainTableInfo = new WorkflowMainTableInfo();
        //主表赋值
        setMainElement(workflowMainTableInfo,37,1,openId);
        workflowRequestInfo.setWorkflowMainTableInfo(workflowMainTableInfo);
        /****************main table end*************/

        //4个明细表赋值
        WorkflowDetailTableInfo[] workflowDetailTableInfo=new WorkflowDetailTableInfo[4];
        //第一张明细表
        setDetailElement(workflowDetailTableInfo, getDbDetailValue1(openId).size(),4,0,getDbDetailColumn1(),getDbDetailValue1(openId));
        //第二张明细表
        setDetailElement(workflowDetailTableInfo, getDbDetailValue2(openId).size(),8,1,getDbDetailColumn2(),getDbDetailValue2(openId));
        //第三张明细表
        setDetailElement(workflowDetailTableInfo, getDbDetailValue3(openId).size(),6,2,getDbDetailColumn3(),getDbDetailValue3(openId));
        //第四张明细表
        setDetailElement(workflowDetailTableInfo, getDbDetailValue4(openId).size(),4,3,getDbDetailColumn4(),getDbDetailValue4(openId));
        workflowRequestInfo.setWorkflowDetailTableInfos(workflowDetailTableInfo);
        /****************detail table end*************/
        //设置流程是否流转下一节点
        workflowRequestInfo.setIsnextflow("0");
        return workflowRequestInfo;
    }

    /**
     * 文本框赋值
     * @param workflowRequestTableFieldList
     * @param dbColumn
     * @param dbValue
     * @param isView
     * @param isEdit
     */
    public  void addElement(WorkflowRequestTableField[] workflowRequestTableFieldList, int index, String dbColumn, String dbValue, Boolean isView, Boolean isEdit){
        workflowRequestTableFieldList[index]=new WorkflowRequestTableField();
        workflowRequestTableFieldList[index].setFieldName(dbColumn);
        workflowRequestTableFieldList[index].setFieldValue(dbValue);
        workflowRequestTableFieldList[index].setView(isView);
        workflowRequestTableFieldList[index].setEdit(isEdit);
    }

    /**
     * 给主表字段赋值属性
     * @return
     */
    public  List<String> getDbColumn(){
        List<String> dbColumnList=new LinkedList<String>();
        dbColumnList.add(0,"name");
        dbColumnList.add(1,"sex");
        dbColumnList.add(2,"dept_id");
        dbColumnList.add(3,"job_application");
        dbColumnList.add(4,"birth");
        dbColumnList.add(5,"nationality");
        dbColumnList.add(6,"native_place");
        dbColumnList.add(7,"nation");
        dbColumnList.add(8,"political_affiliation");
        dbColumnList.add(9,"joining_party_time");
        dbColumnList.add(10,"active_service");
        dbColumnList.add(11,"expected_salary");
        dbColumnList.add(12,"id_card");
        dbColumnList.add(13,"social_security");
        dbColumnList.add(14,"height");
        dbColumnList.add(15,"weight");
        dbColumnList.add(16,"specialities");
        dbColumnList.add(17,"professional_title");
        dbColumnList.add(18,"education");
        dbColumnList.add(19,"marriage");
        dbColumnList.add(20,"bear");
        dbColumnList.add(21,"oneself_phone");
        dbColumnList.add(22,"mail");
        dbColumnList.add(23,"emergency_contact");
        dbColumnList.add(24,"emergency_contact_phone");
        dbColumnList.add(25,"permanent_address");
        dbColumnList.add(26,"home_address");
        dbColumnList.add(27,"current_address");
        dbColumnList.add(28,"computer_level");
        dbColumnList.add(29,"softwares");
        dbColumnList.add(30,"english_level");
        dbColumnList.add(31,"channel_find");
        dbColumnList.add(32,"introducer");
        dbColumnList.add(33,"train_content");
        dbColumnList.add(34,"rewards_punishments_content");
        dbColumnList.add(35,"expertise_content");
        dbColumnList.add(36,"self_evaluation_content");
        return dbColumnList;
    }

    /**
     * 主表赋值
     * @param openId
     * @return
     * @throws Exception
     */
    public  List<String> getDbValue(String openId) throws Exception {
        BaseBasicInfo baseBasicInfo=packageMainInfo(openId);
        BaseOther baseOther=packageOtherInfo(openId);
        List<String> dbValueList=new LinkedList<String>();
        dbValueList.add(0,baseBasicInfo.getName());
        dbValueList.add(1,baseBasicInfo.getSex());
        dbValueList.add(2,baseBasicInfo.getDeptId());
        dbValueList.add(3,baseBasicInfo.getJobApplication());
        dbValueList.add(4,baseBasicInfo.getBirth());
        dbValueList.add(5,baseBasicInfo.getNationality());
        dbValueList.add(6,baseBasicInfo.getNativePlace());
        dbValueList.add(7,baseBasicInfo.getNation());
        dbValueList.add(8,baseBasicInfo.getPoliticalAffiliation());
        dbValueList.add(9,baseBasicInfo.getJoiningPartyTime());
        dbValueList.add(10,baseBasicInfo.getActiveService());
        dbValueList.add(11,baseBasicInfo.getExpectedSalary());
        dbValueList.add(12,baseBasicInfo.getIdCard());
        dbValueList.add(13,baseBasicInfo.getSocialSecurity());
        dbValueList.add(14,baseBasicInfo.getHeight());
        dbValueList.add(15,baseBasicInfo.getWeight());
        dbValueList.add(16,baseBasicInfo.getSpecialities());
        dbValueList.add(17,baseBasicInfo.getProfessionalTitle());
        dbValueList.add(18,baseBasicInfo.getEducation());
        dbValueList.add(19,baseBasicInfo.getMarriage());
        dbValueList.add(20,baseBasicInfo.getBear());
        dbValueList.add(21,baseBasicInfo.getOneselfPhone());
        dbValueList.add(22,baseBasicInfo.getMail());
        dbValueList.add(23,baseBasicInfo.getEmergencyContact());
        dbValueList.add(24,baseBasicInfo.getEmergencyContactPhone());
        dbValueList.add(25,baseBasicInfo.getPermanentAddress());
        dbValueList.add(26,baseBasicInfo.getHomeAddress());
        dbValueList.add(27,baseBasicInfo.getCurrentAddress());
        dbValueList.add(28,baseBasicInfo.getComputerLevel());
        dbValueList.add(29,baseBasicInfo.getSoftwares());
        dbValueList.add(30,baseBasicInfo.getEnglishLevel());
        dbValueList.add(31,baseBasicInfo.getChannelFind());
        dbValueList.add(32,baseBasicInfo.getIntroducer());
        dbValueList.add(33,baseOther.getTrainContent());
        dbValueList.add(34,baseOther.getRewardsPunishmentsContent() );
        dbValueList.add(35,baseOther.getExpertiseContent());
        dbValueList.add(36,baseOther.getSelfEvaluationContent());
        return dbValueList;
    }

    /**
     * 给明细表1字段赋值属性
     * @return
     */
    public  List<String> getDbDetailColumn1(){
        List<String> dbColumnList=new LinkedList<String>();
        dbColumnList.add(0,"start_time");
        dbColumnList.add(1,"end_time");
        dbColumnList.add(2,"school");
        dbColumnList.add(3,"specialty");
        return dbColumnList;
    }

    /**
     * 明细表1赋值
     * @param openId
     * @return
     * @throws Exception
     */
    public  Map<Integer,List<String>> getDbDetailValue1(String openId) throws Exception {
        List<BaseEducationExperience> baseEducationExperienceList=packageDetail1(openId);
        Map<Integer,List<String>> map  = new LinkedHashMap<>();
        int count = 0;
        for(BaseEducationExperience baseEducationExperience:baseEducationExperienceList){
            List<String> dbValueList=new LinkedList<String>();
            dbValueList.add(0,baseEducationExperience.getStartTime());
            dbValueList.add(1,baseEducationExperience.getEndTime());
            dbValueList.add(2,baseEducationExperience.getSchool());
            dbValueList.add(3,baseEducationExperience.getSpecialty());
            map.put(count,dbValueList);
            count++;
        }
        return map;
    }

    /**
     * 给明细表2字段赋值属性
     * @return
     */
    public  List<String> getDbDetailColumn2(){
        List<String> dbColumnList=new LinkedList<String>();
        dbColumnList.add(0,"start_time");
        dbColumnList.add(1,"end_time");
        dbColumnList.add(2,"work_unit");
        dbColumnList.add(3,"work_job");
        dbColumnList.add(4,"salary");
        dbColumnList.add(5,"witness");
        dbColumnList.add(6,"witness_phone");
        dbColumnList.add(7,"reasons");
        return dbColumnList;
    }

    /**
     * 明细表2赋值
     * @param openId
     * @return
     * @throws Exception
     */
    public  Map<Integer,List<String>> getDbDetailValue2(String openId) throws Exception {
        List<BaseWorkExperience> baseEducationExperienceList=packageDetail2(openId);
        Map<Integer,List<String>> map  = new LinkedHashMap<>();
        int count = 0;
        for(BaseWorkExperience baseEducationExperience:baseEducationExperienceList){
            List<String> dbValueList=new LinkedList<String>();
            dbValueList.add(0,baseEducationExperience.getStartTime());
            dbValueList.add(1,baseEducationExperience.getEndTime());
            dbValueList.add(2,baseEducationExperience.getWorkUnit());
            dbValueList.add(3,baseEducationExperience.getWorkJob());
            dbValueList.add(4,baseEducationExperience.getSalary());
            dbValueList.add(5,baseEducationExperience.getWitness());
            dbValueList.add(6,baseEducationExperience.getWitnessPhone());
            dbValueList.add(7,baseEducationExperience.getReasons());
            map.put(count,dbValueList);
            count++;
        }
        return map;
    }
    /**
     * 给明细表3字段赋值属性
     * @return
     */
    public  List<String> getDbDetailColumn3(){
        List<String> dbColumnList=new LinkedList<String>();
        dbColumnList.add(0,"family_name");
        dbColumnList.add(1,"birth_year");
        dbColumnList.add(2,"family_relationship");
        dbColumnList.add(3,"family_unit");
        dbColumnList.add(4,"family_job");
        dbColumnList.add(5,"family_phone");
        return dbColumnList;
    }

    /**
     * 明细表3赋值
     * @param openId
     * @return
     * @throws Exception
     */
    public  Map<Integer,List<String>> getDbDetailValue3(String openId) throws Exception {
        List<BaseFamilyMember> baseFamilyMembersList=packageDetail3(openId);
        Map<Integer,List<String>> map  = new LinkedHashMap<>();
        int count = 0;
        for(BaseFamilyMember baseFamilyMember:baseFamilyMembersList){
            List<String> dbValueList=new LinkedList<String>();
            dbValueList.add(0,baseFamilyMember.getFamilyName());
            dbValueList.add(1,baseFamilyMember.getBirthYear());
            dbValueList.add(2,baseFamilyMember.getFamilyRelationship());
            dbValueList.add(3,baseFamilyMember.getFamilyUnit());
            dbValueList.add(4,baseFamilyMember.getFamilyJob());
            dbValueList.add(5,baseFamilyMember.getFamilyPhone());
            map.put(count,dbValueList);
            count++;
        }
        return map;
    }

    /**
     * 给明细表4字段赋值属性
     * @return
     */
    public  List<String> getDbDetailColumn4(){
        List<String> dbColumnList=new LinkedList<String>();
        dbColumnList.add(0,"relatives_name");
        dbColumnList.add(1,"relatives_relationship");
        dbColumnList.add(2,"relatives_unit");
        dbColumnList.add(3,"relatives_job");
        return dbColumnList;
    }

    /**
     * 明细表4赋值
     * @param openId
     * @return
     * @throws Exception
     */
    public  Map<Integer,List<String>> getDbDetailValue4(String openId) throws Exception {
        List<BaseRelatives> baseRelativesList=packageDetail4(openId);
        Map<Integer,List<String>> map  = new LinkedHashMap<>();
        int count = 0;
        for(BaseRelatives baseRelatives:baseRelativesList){
            List<String> dbValueList=new LinkedList<String>();
            dbValueList.add(0,baseRelatives.getRelativesName());
            dbValueList.add(1,baseRelatives.getRelativesRelationship());
            dbValueList.add(2,baseRelatives.getRelativesUnit());
            dbValueList.add(3,baseRelatives.getRelativesJob());
            map.put(count,dbValueList);
            count++;
        }
        return map;
    }

    /**
     * 添加主表信息
     * @param workflowMainTableInfo
     * @param fieldNumber
     * @param attachmentNumber
     */
    public  void setMainElement(WorkflowMainTableInfo workflowMainTableInfo, Integer fieldNumber, Integer attachmentNumber,String openId) throws Exception{
        //主表字段只有一条记录
        WorkflowRequestTableRecord[] workflowRequestTableRecord = new WorkflowRequestTableRecord[1];
        //主的40个字段
        WorkflowRequestTableField[] WorkflowRequestTableFieldList = new WorkflowRequestTableField[fieldNumber+attachmentNumber];
        //定义数据库字段
        List<String> dbColumnList=getDbColumn();
        //定义数据库值
        List<String> dbValueList=getDbValue(openId);
        for(int i=0;i<fieldNumber;i++){
            addElement(WorkflowRequestTableFieldList,i,dbColumnList.get(i),dbValueList.get(i),true,true);
        }
        WorkflowRequestTableFieldList[fieldNumber]=new WorkflowRequestTableField();
        WorkflowRequestTableFieldList[fieldNumber].setFieldName("photo");
        WorkflowRequestTableFieldList[fieldNumber].setFieldType("http:zichan.png");
        WorkflowRequestTableFieldList[fieldNumber].setFieldValue("http://10.10.65.106:7454/img/zichan.png");
        WorkflowRequestTableFieldList[fieldNumber].setView(true);
        WorkflowRequestTableFieldList[fieldNumber].setEdit(true);
        workflowRequestTableRecord[0] = new WorkflowRequestTableRecord();
        workflowRequestTableRecord[0].setWorkflowRequestTableFields(WorkflowRequestTableFieldList);
        workflowMainTableInfo.setRequestRecords(workflowRequestTableRecord);
    }

    /**
     * 添加明细表信息
     * @param workflowDetailTableInfo
     * @param recordNumber
     * @param fieldNumber
     * @param detailNumber
     * @param dbDetailColumnList
     * @param dbDetailValueList
     */
    public  void setDetailElement(WorkflowDetailTableInfo[] workflowDetailTableInfo,
                                  Integer recordNumber, Integer fieldNumber, Integer detailNumber,
                                  List<String> dbDetailColumnList, Map<Integer, List<String>> dbDetailValueList){
        //明细表有1条记录
        WorkflowRequestTableRecord[] workflowRequestTableRecord = new WorkflowRequestTableRecord[recordNumber];
        for(int i=0;i<recordNumber;i++){
            //每条记录有4个字段
            WorkflowRequestTableField[] workflowRequestTableFieldList = new WorkflowRequestTableField[fieldNumber];
            for(int j=0;j<fieldNumber;j++){
                addElement(workflowRequestTableFieldList,j,dbDetailColumnList.get(j),dbDetailValueList.get(i).get(j),true,true);
            }
            workflowRequestTableRecord[i] = new WorkflowRequestTableRecord();
            workflowRequestTableRecord[i].setWorkflowRequestTableFields(workflowRequestTableFieldList);
        }
        workflowDetailTableInfo[detailNumber]=new WorkflowDetailTableInfo();
        workflowDetailTableInfo[detailNumber].setWorkflowRequestTableRecords(workflowRequestTableRecord);
    }
    /**
     * 根据openid获取当前面试人员信息
     * @param openId
     * @return BaseBasicInfo
     * @throws Exception
     */
    public  BaseBasicInfo packageMainInfo(String openId) throws Exception {
        BaseBasicInfo baseBasicInfo=new BaseBasicInfo();
        String getMainTableSql="select name,sex,dept_id,birth,nationality,native_place,nation,political_affiliation," +
                "joining_party_time, active_service,job_application,id_card, social_security, height, weight, education, " +
                "specialities, professional_title, marriage, bear, oneself_phone, mail, emergency_contact, " +
                "emergency_contact_phone, permanent_address, permanent_address_detail, home_address, " +
                "home_address_detail, current_address, current_address_detail, computer_level, softwares," +
                " english_level, channel_find, introducer, expected_salary,  entry_status, base_id, open_id, " +
                "  basic_recruit_status from base_basic_info where open_id='"+openId+"'";
        //System.out.println("getMainTableSql = " + getMainTableSql);
        ResultSet getMainTableRs=  getSelectResultSet(getMainTableSql);
        while (getMainTableRs.next()) {
            baseBasicInfo.setName(getMainTableRs.getString("name"));
            baseBasicInfo.setSex(getMainTableRs.getString("sex"));
            baseBasicInfo.setDeptId(getMainTableRs.getString("dept_id"));
            baseBasicInfo.setBirth(getMainTableRs.getString("birth"));
            baseBasicInfo.setNationality(getMainTableRs.getString("nationality"));
            baseBasicInfo.setNativePlace(getMainTableRs.getString("native_place"));
            baseBasicInfo.setNation(getMainTableRs.getString("nation"));
            baseBasicInfo.setPoliticalAffiliation(getMainTableRs.getString("political_affiliation"));
            baseBasicInfo.setJoiningPartyTime(getMainTableRs.getString("joining_party_time"));
            baseBasicInfo.setActiveService(getMainTableRs.getString("active_service"));
            baseBasicInfo.setJobApplication(getMainTableRs.getString("job_application"));
            baseBasicInfo.setIdCard(getMainTableRs.getString("id_card"));
            baseBasicInfo.setSocialSecurity(getMainTableRs.getString("social_security"));
            baseBasicInfo.setHeight(getMainTableRs.getString("height"));
            baseBasicInfo.setWeight(getMainTableRs.getString("weight"));
            baseBasicInfo.setEducation(getMainTableRs.getString("education"));
            baseBasicInfo.setSpecialities(getMainTableRs.getString("specialities"));
            baseBasicInfo.setProfessionalTitle(getMainTableRs.getString("professional_title"));
            baseBasicInfo.setMarriage(getMainTableRs.getString("marriage"));
            baseBasicInfo.setBear(getMainTableRs.getString("bear"));
            baseBasicInfo.setOneselfPhone(getMainTableRs.getString("oneself_phone"));
            baseBasicInfo.setMail(getMainTableRs.getString("mail"));
            baseBasicInfo.setEmergencyContact(getMainTableRs.getString("emergency_contact"));
            baseBasicInfo.setEmergencyContactPhone(getMainTableRs.getString("emergency_contact_phone"));
            baseBasicInfo.setPermanentAddress(getMainTableRs.getString("permanent_address"));
            baseBasicInfo.setHomeAddress(getMainTableRs.getString("home_address"));
            baseBasicInfo.setCurrentAddress(getMainTableRs.getString("current_address"));
            baseBasicInfo.setComputerLevel(getMainTableRs.getString("computer_level"));
            baseBasicInfo.setSoftwares(getMainTableRs.getString("softwares"));
            baseBasicInfo.setEnglishLevel(getMainTableRs.getString("english_level"));
            baseBasicInfo.setChannelFind(getMainTableRs.getString("channel_find"));
            baseBasicInfo.setIntroducer(getMainTableRs.getString("introducer"));
            baseBasicInfo.setExpectedSalary(getMainTableRs.getString("expected_salary"));
            baseBasicInfo.setEntryStatus(getMainTableRs.getString("entry_status"));
            baseBasicInfo.setBaseId(getMainTableRs.getString("base_id"));
            baseBasicInfo.setOpenId(getMainTableRs.getString("open_id"));
            baseBasicInfo.setBasicRecruitStatus(getMainTableRs.getString("basic_recruit_status"));
        }
        return baseBasicInfo;
    }

    /**
     * 根据openid查询出baseid,封装其他字段
     * @param openId
     * @return
     * @throws Exception
     */
    public  BaseOther packageOtherInfo(String openId) throws Exception {
        BaseOther baseOther=new BaseOther();
        String baseId=getBaseId(openId);
        String getBaseOtherSql="select train_content,rewards_punishments_content,expertise_content," +
                "self_evaluation_content from base_other where base_id='"+baseId+"'";
        ResultSet resultSet=getSelectResultSet(getBaseOtherSql);
        while (resultSet.next()){
            baseOther.setTrainContent(resultSet.getString("train_content"));
            baseOther.setRewardsPunishmentsContent(resultSet.getString("rewards_punishments_content"));
            baseOther.setExpertiseContent(resultSet.getString("expertise_content"));
            baseOther.setSelfEvaluationContent(resultSet.getString("self_evaluation_content"));
        }
        return baseOther;
    }

    /**
     * sql连接
     * @param sql
     * @return
     * @throws Exception
     */
    public  ResultSet getSelectResultSet(String sql) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.22.0.195:3306/hd_emp_info","root","Hongdou$2018");
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    /**
     * 获取主表的id
     * @param openId
     * @return
     * @throws Exception
     */
    public  String getBaseId(String openId) throws Exception {
        String getBaseIdSql="select id from  base_basic_info where open_id='"+openId+"'";
        ResultSet resultSet=getSelectResultSet(getBaseIdSql);
        String baseId = null;
        while (resultSet.next()){
            baseId=resultSet.getString(1);
        }
        return baseId;
    }

    /**
     * 封装明细表1
     * @return  List<BaseEducationExperience>
     * @throws Exception
     */
    public  List<BaseEducationExperience> packageDetail1(String openId) throws Exception{
        List<BaseEducationExperience> baseEducationExperienceList = new ArrayList<BaseEducationExperience> ();
        String baseId=getBaseId(openId);
        String sql = "SELECT start_time,end_time,school,specialty FROM base_education_experience  where base_id='"+baseId+"'";
        System.out.println("sql = " + sql);
        ResultSet rs = getSelectResultSet(sql);
        while (rs.next()) {
            BaseEducationExperience baseEducationExperience = new BaseEducationExperience();
            baseEducationExperience.setStartTime(rs.getString("start_time"));
            baseEducationExperience.setEndTime(rs.getString("end_time"));
            baseEducationExperience.setSchool(rs.getString("school"));
            baseEducationExperience.setSpecialty(rs.getString("specialty"));
            baseEducationExperienceList.add(baseEducationExperience);
        }
        return baseEducationExperienceList;
    }

    /**
     * 封装明细表2
     * @param openId
     * @return List<BaseWorkExperience>
     * @throws Exception
     */
    public  List<BaseWorkExperience> packageDetail2(String openId) throws Exception{
        List<BaseWorkExperience> baseWorkExperienceList = new ArrayList<BaseWorkExperience> ();
        String baseId=getBaseId(openId);
        String sql = "SELECT start_time,end_time,work_unit,work_job,salary,witness,witness_phone,reasons" +
                " FROM base_work_experience  where base_id='"+baseId+"'";
        ResultSet rs = getSelectResultSet(sql);
        while (rs.next()) {
            BaseWorkExperience baseWorkExperience = new BaseWorkExperience();
            baseWorkExperience.setStartTime(rs.getString("start_time"));
            baseWorkExperience.setEndTime(rs.getString("end_time"));
            baseWorkExperience.setWorkUnit(rs.getString("work_unit"));
            baseWorkExperience.setWorkJob(rs.getString("work_job"));
            baseWorkExperience.setSalary(rs.getString("salary"));
            baseWorkExperience.setWitness(rs.getString("witness"));
            baseWorkExperience.setWitnessPhone(rs.getString("witness_phone"));
            baseWorkExperience.setReasons(rs.getString("reasons"));
            baseWorkExperienceList.add(baseWorkExperience);
        }
        return baseWorkExperienceList;
    }

    /**
     * 封装明细表3
     * @param openId
     * @return Map<Integer, List<String>>
     * @throws Exception
     */
    public  List<BaseFamilyMember> packageDetail3(String openId) throws Exception{
        List<BaseFamilyMember> baseFamilyMembersList = new ArrayList<BaseFamilyMember>();
        String baseId=getBaseId(openId);
        String sql = "SELECT family_name,birth_year,family_relationship,family_unit,family_job,family_phone" +
                " FROM base_family_member  where base_id='"+baseId+"'";
        ResultSet rs = getSelectResultSet(sql);
        while (rs.next()) {
            BaseFamilyMember baseFamilyMember = new BaseFamilyMember();
            baseFamilyMember.setFamilyName(rs.getString("family_name"));
            baseFamilyMember.setBirthYear(rs.getString("birth_year"));
            baseFamilyMember.setFamilyRelationship(rs.getString("family_relationship"));
            baseFamilyMember.setFamilyUnit(rs.getString("family_unit"));
            baseFamilyMember.setFamilyJob(rs.getString("family_job"));
            baseFamilyMember.setFamilyPhone(rs.getString("family_phone"));
            baseFamilyMembersList.add(baseFamilyMember);
        }
        return baseFamilyMembersList;
    }

    /**
     * 封装明细表4
     * @param openId
     * @return Map<Integer, List<String>>
     * @throws Exception
     */
    public  List<BaseRelatives> packageDetail4(String openId) throws Exception{
        List<BaseRelatives> baseRelativesList = new ArrayList<BaseRelatives>();
        String baseId=getBaseId(openId);
        String sql = "SELECT relatives_name,relatives_relationship,relatives_unit,relatives_job" +
                " FROM base_relatives  where base_id='"+baseId+"'";
        ResultSet rs = getSelectResultSet(sql);
        while (rs.next()) {
            BaseRelatives baseRelatives = new BaseRelatives();
            baseRelatives.setRelativesName(rs.getString("relatives_name"));
            baseRelatives.setRelativesRelationship(rs.getString("relatives_relationship"));
            baseRelatives.setRelativesUnit(rs.getString("relatives_unit"));
            baseRelatives.setRelativesJob(rs.getString("relatives_job"));
            baseRelativesList.add(baseRelatives);
        }
        return baseRelativesList;
    }

}
