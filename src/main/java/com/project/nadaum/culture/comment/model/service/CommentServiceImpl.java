package com.project.nadaum.culture.comment.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.nadaum.culture.comment.model.dao.CommentDao;
import com.project.nadaum.culture.comment.model.vo.Comment;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override 
	public List<Comment> selectCultureCommentList(String apiCode) {
		return commentDao.selectCultureCommentList(apiCode);
	}

	@Override
	public int insertCultureComment(Map<String, Object> map) {
		return commentDao.insertCultureComment(map);
	}

	@Override
	public int updateCultureComment(Map<String, Object> map) {
		return commentDao.updateCultureComment(map);
	}

	@Override
	public int deleteCultureComment(String code) {
		return commentDao.deleteCultureComment(code);
	}

	//영화댓글
	@Override
	public List<Comment> selectMovieCommentList(String apiCode) {
		return commentDao.selectMovieCommentList(apiCode);
	}

	@Override
	public int insertMovieComment(Map<String, Object> map) {
		return commentDao.insertMovieComment(map);
	}

//	@Override
//	public int updateMovieComment(String code) {
//		return commentDao.updateMovieComment(code);
//	}

	@Override
	public int updateMovieComment(Comment comment) {
		return commentDao.updateMovieComment(comment);
	}

	@Override
	public Comment selectOneComment(String code) {
		return commentDao.selectOneComment(code);
	}

}
