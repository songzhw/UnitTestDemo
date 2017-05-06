package ca.six.todo.tasks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ca.six.todo.data.Task;
import ca.six.todo.data.source.TasksDataSource;
import ca.six.todo.data.source.TasksRepository;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TasksPresenterTest {
    @Mock TasksContract.View view;
    @Mock TasksRepository repo;
    @Captor ArgumentCaptor<TasksDataSource.LoadTasksCallback> captor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(view.isActive()).thenReturn(true);
    }

    @Test
    public void testFirstEnters_listShouldBeEmpty(){
        TasksPresenter presenter = new TasksPresenter(repo, view);
        presenter.start();

        verify(view).setLoadingIndicator(true);
        verify(repo).refreshTasks();

        verify(repo).getTasks(captor.capture());
        captor.getValue().onTasksLoaded(new ArrayList<Task>());

        // default filter is : All_Tasks
        verify(view).showNoTasks();
    }

    @Test
    public void testFirstEnters_getDataFailed(){
        TasksPresenter presenter = new TasksPresenter(repo, view);
        presenter.start();

        verify(repo).getTasks(captor.capture());
        captor.getValue().onDataNotAvailable();

        verify(view).showLoadingTasksError();
    }
    @Test
    public void showMultipleTasks(){
        TasksPresenter presenter = new TasksPresenter(repo, view);
        presenter.start();

        Task[] tmp = new Task[]{
                new Task("01","u", false),
                new Task("02","", false),
                new Task("03","", true),
                new Task("04","x", false)
        };
        List<Task> tasks = Arrays.asList(tmp);

        verify(repo).getTasks(captor.capture());
        captor.getValue().onTasksLoaded(tasks);

        verify(view).showTasks(tasks);
        verify(view).showAllFilterLabel();

    }


}
