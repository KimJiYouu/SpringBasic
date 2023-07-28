package com.simple.mapper;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreMapper {
	public void scoreRegist(ScoreVO vo);
	public ArrayList<ScoreVO> getScores();
	public void scoreDelete(int index);

}
