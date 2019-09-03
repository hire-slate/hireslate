package com.hireslate.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hireslate.model.SkillMasterEntity;

@Repository
public class SkillMasterRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<SkillMasterEntity> view(){
		
		String sql = "select * from skill_master";
		List<SkillMasterEntity> skills = new ArrayList<SkillMasterEntity>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(sql);
		
		for(Map<String,Object> row : rows) {
			SkillMasterEntity skill = new SkillMasterEntity();
			skill.setSkillId((int)row.get("Skill_Id"));
			skill.setSkillName((String)row.get("Skill_Name"));
			skills.add(skill);	
		}
		return skills;
	}
	
	public void insert(String name) {
		String sql = "insert into skill_master (Skill_Name) values ('"+name+"')";
		jdbcTemplate.execute(sql);
		
	}
	
	public void update(SkillMasterEntity skill) {
		String sql = "update skill_master set Skill_Name = '"+skill.getSkillName()+"' where Skill_Id = "+skill.getSkillId()+";"; 
		jdbcTemplate.execute(sql);
	}
	
	public SkillMasterEntity viewById(int id) {
		String sql = "select * from skill_master where Skill_Id = "+ id;
		Map<String,Object> row = jdbcTemplate.queryForMap(sql);
		SkillMasterEntity skill = new SkillMasterEntity();
		skill.setSkillId((int)row.get("Skill_Id"));
		skill.setSkillName((String)row.get("Skill_Name"));
		return skill;
	}
	
	public void delete(int id) {
		String sql = "delete from skill_master where Skill_Id = "+id; 
		jdbcTemplate.execute(sql);
	}	
}
