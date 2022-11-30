package br.com.seireitei.api.urahara.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seireitei.api.urahara.model.task.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
  
}
