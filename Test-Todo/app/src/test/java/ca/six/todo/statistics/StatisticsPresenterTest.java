package ca.six.todo.statistics;


import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ca.six.todo.data.Task;
import ca.six.todo.data.source.TasksDataSource;
import ca.six.todo.data.source.TasksRepository;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class StatisticsPresenterTest {
    @Mock TasksRepository repo;
    @Mock StatisticsContract.View view;
    @Captor ArgumentCaptor<TasksDataSource.LoadTasksCallback> captor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loadTaskStatisticsSucc() {
        StatisticsPresenter presenter = new StatisticsPresenter(repo, view);
        presenter.start();

        Task task1 = new Task("1", "1", true);
        Task task2 = new Task("2", "2", false);
        Task task3 = new Task("3", "3", true);
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);

        verify(repo).getTasks(captor.capture());
        captor.getValue().onTasksLoaded(taskList);

        verify(view).showStatistics(1, 2);
    }

    @Test
    public void loadTaskStatisticsFail() {

    }

    @Test
    public void tasksIsEmpty_ShowEmptyUI() {

    }
}