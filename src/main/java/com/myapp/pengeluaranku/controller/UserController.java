package com.myapp.pengeluaranku.controller;

import java.util.List;

import javax.xml.ws.Response;

import com.myapp.pengeluaranku.service.UserService;
import com.myapp.pengeluaranku.util.RestUtil;
import com.myapp.pengeluaranku.vo.UserReqVO;
import com.myapp.pengeluaranku.vo.UserResVO;
import com.myapp.pengeluaranku.vo.ResultVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pengeluaranku-service/api/v1/user")
public class UserController{

    @Autowired
    UserService userService;
    @PostMapping(value="/add")
    public ResponseEntity<ResultVO> add(@RequestBody UserReqVO vo){
        ResultVO result = new ResultVO();
        String results = userService.add(vo);
        result.setMessage("User tersimpan");
        result.setResults(results);
        result.setStatus(201);

        return RestUtil.getJsonResponse(result);
        
    }

    @PutMapping(value="/edit")
    public ResponseEntity<ResultVO> edit(@RequestBody UserReqVO vo,
                                         @RequestParam(value="uuid") String uuid){
        ResultVO result = new ResultVO();
        String results = userService.edit(vo,uuid);
        result.setMessage("User terupdate");
        result.setResults(results);
        result.setStatus(200);

        return RestUtil.getJsonResponse(result);
        
    }

    @DeleteMapping(value="/delete")
    public ResponseEntity<ResultVO> delete(@RequestParam(value="uuid") String uuid){
        ResultVO result = new ResultVO();
        String results = userService.delete(uuid);
        result.setMessage("User terhapus");
        result.setResults(results);
        result.setStatus(200);

        return RestUtil.getJsonResponse(result);
        
    }
    @GetMapping(value="/list")
    public ResponseEntity<ResultVO> list(){
        ResultVO result = new ResultVO();
        List<UserResVO> results = userService.list();
        result.setMessage("User diperoleh");
        result.setResults(results);
        result.setStatus(200);

        return RestUtil.getJsonResponse(result);
        
    }
    @GetMapping(value="/get-all")
    public ResponseEntity<ResultVO> getAll(){
        ResultVO result = new ResultVO();
        List<String> results = userService.getAll();
        result.setMessage("User ditemukan");
        result.setResults(results);
        result.setStatus(200);
        return RestUtil.getJsonResponse(result);

    }
    
}