package Spider_transnational;
import java.time.LocalDateTime;

//自动化生成SQL
public class autoSql {
	
	public static String createFakeEvaluate(){
		String result = "";
		LocalDateTime now = LocalDateTime.now();
		
		//疾病表
		String tableName = "CT_PATIENT_IN_HOSPITAL_APPRAISE";
		Integer columnNumber = 700;
		for(int i=551; i<=columnNumber; ++i){
			String PATIENT_IN_HOSPITAL_APPRAISE_Id = i+"";
			String PATIENT_IN_HOSPITAL_KEY_ID = "1020";
			String APPRAISE_VALUE ="1";
			String APPRAISE_NAME ="一";
			result+=("INSERT INTO "+tableName+"() value ("+PATIENT_IN_HOSPITAL_APPRAISE_Id+", \""+PATIENT_IN_HOSPITAL_KEY_ID+"\", \""+APPRAISE_VALUE+"\", \""+APPRAISE_NAME+"\", \""+now+"\", 1);\n" );
		}
		
		
		return result;
	}
	
	
	public static String createFakeData(){
		String result = "";
		LocalDateTime now = LocalDateTime.now();
		
		//疾病表
		String tableName = "CT_KNOWLEDGE_DISEASE";
		Integer columnNumber = 177;
		for(int i=1; i<=columnNumber; ++i){
			String diseaseId = i+"";
			String diseaseName = "病"+i;
			String hospitalId ="1";
			String creatorId = "21";
			result+=("INSERT INTO "+tableName+"() value ("+diseaseId+", \""+diseaseName+"\", \""+hospitalId+"\", \""+creatorId+"\", \""+now+"\", \""+creatorId+"\", \""+now+"\", 1);\n" );
		}
		//疾病描述表
		String tableName2 = "CT_KNOWLEDGE_DISEASE_DESCRIPTION";
		for(int i=1; i<=columnNumber; ++i){
			String diseaseId = i+"";
			String diseaseDescriptionContent = "may the force be with you!";
			result+=("INSERT INTO "+tableName2+" () VALUE ("+((i-1)*7+1)+", "+diseaseId+", \"概述\", \""+diseaseDescriptionContent+"\", 1);\n");
			result+=("INSERT INTO "+tableName2+" () VALUE ("+((i-1)*7+2)+", "+diseaseId+", \"病因\", \""+diseaseDescriptionContent+"\", 1);\n");
			result+=("INSERT INTO "+tableName2+" () VALUE ("+((i-1)*7+3)+", "+diseaseId+", \"临床表现\", \""+diseaseDescriptionContent+"\", 1);\n");
			result+=("INSERT INTO "+tableName2+" () VALUE ("+((i-1)*7+4)+", "+diseaseId+", \"检查\", \""+diseaseDescriptionContent+"\", 1);\n");
			result+=("INSERT INTO "+tableName2+" () VALUE ("+((i-1)*7+5)+", "+diseaseId+", \"诊断\", \""+diseaseDescriptionContent+"\", 1);\n");
			result+=("INSERT INTO "+tableName2+" () VALUE ("+((i-1)*7+6)+", "+diseaseId+", \"治疗\", \""+diseaseDescriptionContent+"\", 1);\n");
			result+=("INSERT INTO "+tableName2+" () VALUE ("+((i-1)*7+7)+", "+diseaseId+", \"预防\", \""+diseaseDescriptionContent+"\", 1);\n");
			
		}
		
		//科室疾病表
		String tableName3 = "CT_KNOWLEDGE_DEPT_DISEASE_REL";
		for(int i=1,j=1; i<=columnNumber; ++i){
			String deptId = j+"";
			String diseaseId = i+"";
			result+=("INSERT INTO "+tableName3+" () value ("+deptId+", "+diseaseId+");\n");
			if(j<36){
				++j;
			}
		}
		
		
		
		
		return result;
	}

}
