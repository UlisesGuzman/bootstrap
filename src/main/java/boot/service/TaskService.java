package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import boot.model.Task;
import boot.dao.TaskRepository;

@Service @Transactional
public class TaskService {
	private final TaskRepository taskRepository;
	
	public TaskService(TaskRepository taskRepository){
		super();
		this.taskRepository= taskRepository;
	}
	
	public List <Task> findAll(){
		List<Task> tasks = new ArrayList<Task>();
		for(Task task : taskRepository.findAll() ){
			tasks.add(task);
		}
		return tasks;
	}
	
	
	public void save(Task task){
		taskRepository.save(task);
	}
	
	
	public void delete(int id){
		taskRepository.delete(id);
	}
	public  Task finOne(int id){
	return taskRepository.findOne(id);
	}
}
