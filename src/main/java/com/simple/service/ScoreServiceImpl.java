package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.mapper.ScoreMapper;

@Service("scoreService") //컴포넌트 스캔에 읽히면 자동으로 빈 등록 //"이름정하는 규칙: 소문자로 시작하는 인터페이스명"
public class ScoreServiceImpl implements ScoreService{
	
	@Autowired
	private ScoreMapper scoreMapper;

	@Override
	public void scoreRegist(ScoreVO vo) {
		
		scoreMapper.scoreRegist(vo);
		
	}

	@Override
	public ArrayList<ScoreVO> getScores() {
		
		return scoreMapper.getScores();
	}

	@Override
	public void scoreDelete(int index) {
		scoreMapper.scoreDelete(index);
		
	}
	
	
	
	
	
	
	
	
	
//	//DAO 영역
//	@Autowired
//	@Qualifier("xxx")
//	ScoreDAO scoreDAO;
//
//	@Override
//	public void scoreRegist(ScoreVO vo) {
//		scoreDAO.scoreRegist(vo);
//	}
//
//	@Override
//	public ArrayList<ScoreVO> getScores() {
//		
//		return scoreDAO.getScores();
//	}
//
//	@Override
//	public void scoreDelete(int index) {
//		scoreDAO.scoreDelete(index);
//	}

}
