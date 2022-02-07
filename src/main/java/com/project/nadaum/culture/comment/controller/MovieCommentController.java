package com.project.nadaum.culture.comment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.nadaum.culture.comment.model.service.CommentService;
import com.project.nadaum.culture.movie.model.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/movie")
public class MovieCommentController{
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CommentService commentService;

	//============================= 댓  글 =================================================
	
	///등록
	@PostMapping("/movieDetail/{apiCode}")
	public ResponseEntity<?> insertCultureComment(@RequestParam Map<String,Object> map) {
		log.debug("map = {}", map);
		try {
			int result = commentService.insertCultureComment(map);
			
			
			
			map.put("msg", "댓글 등록성공!");
			map.put("result", result);
			if(result == 1) {
                return ResponseEntity.ok(map);
            } 
            else {
            	return ResponseEntity.status(404).build();
            }
		}
		catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	//삭제
		@DeleteMapping("/movieDetail/{apiCode}/{code}")
		public ResponseEntity<?> deleteMenu(@PathVariable String code){
			log.info("code = {}", code);
			 
			try {
				int result = commentService.deleteCultureComment(code);
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("msg", "댓글 삭제 성공!");
				map.put("result", result);
				System.out.println(map);
				
				if(result == 1) {
	                return ResponseEntity.ok(map);
	            } 
	            else {
	            	return ResponseEntity.status(404).build();
	            }
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				return ResponseEntity.badRequest().build();
			}
		}
		
		
		
	//수정
	@PutMapping("/movieDetail.do/{apiCode}/{code}")
	public ResponseEntity<?> updateMenu(@RequestParam Map<String,Object> map){
		log.debug("map = {}", map);
		try {
			int result = commentService.updateCultureComment(map);
			log.debug("result = {}", result);
			
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("msg", "댓글 수정 성공!");
			resultMap.put("result", result);
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	

}
