package ca.six.todo.taskdetail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ca.six.todo.addedittask.AddEditTaskContract;
import ca.six.todo.data.source.TasksDataSource;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TaskDetailPresenterTest {
    @Mock TasksDataSource repo;
    @Mock AddEditTaskContract.View view;
    @Captor ArgumentCaptor<TasksDataSource.GetTaskCallback> captor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(view.isActive()).thenReturn(true);
    }

    @Test
    public void start_notFoundTask(){
        // use captor.getValue().onTaskLoader(null) to test
    }

    @Test
    public void start_dataNotAvailable(){
        // use captor.getValue().onDataNotAvailable() to test
    }

    @Test
    public void start_showExactTask(){
        // use captor.getValue().onTaskLoader(new Task(...)) to test
    }

    @Test
    public void editTask_jumpToEditScreen(){
        // verify(view).showEditTask(taskId)
    }

    @Test
    public void deleteTaskSuccessfully(){
        // verify(repo).deleteTask() + verify(view).showTaskDeleted()
    }

    @Test
    public void completeTaskSuccessfully(){
        // verify(repo).completeTask() + verify(view).showTaskMarkedComplete()
    }

    @Test
    public void activateTaskSuccessfully(){
        // verify(repo).activateTask() + verify(view).showTaskMarkedActive()
    }
}