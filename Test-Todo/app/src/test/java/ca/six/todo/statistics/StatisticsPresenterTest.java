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

    }

    @Test
    public void loadTaskStatisticsFail() {

    }

    @Test
    public void tasksIsEmpty_ShowEmptyUI() {

    }
}