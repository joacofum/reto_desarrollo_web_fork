package com.sofka.Software.controller;

import com.sofka.Software.models.ListTaskModel;
import com.sofka.Software.services.ListTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://127.0.0.1:5501")
@RestController
public class ListTaskController {
    @Autowired
    private ListTaskService listTaskService;

    @GetMapping(path = "/listTasks")
    public Iterable<ListTaskModel> list(){
        return listTaskService.list();
    }

    @PostMapping(path = "/listTask")
    public ListTaskModel createListTask(@RequestBody ListTaskModel listTask){
        return listTaskService.createListTask(listTask);
    }

    @PutMapping(path = "/listTask/{id}")
    public ListTaskModel updatelistTask(@RequestBody ListTaskModel listTask, @PathVariable(value="id") Long id ) {
        System.out.println(listTask.toString());
        return listTaskService.updateListTask(id, listTask);
    }

    @PutMapping(path = "/completar/{id}")
    public ListTaskModel updatelistTask(@PathVariable(value="id") Long id ) {
        return listTaskService.completarTask(id);
    }

     @DeleteMapping(path = "/listTask/{id}")
     public void deletelistTask(@PathVariable("id")Long id){
        listTaskService.deleteListTask(id);
     }
}
