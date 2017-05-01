package ca.six.todo.addedittask;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ca.six.todo.data.source.TasksDataSource;

public class AddEditTaskPresenterTest {
    @Mock AddEditTaskContract.View view;
    @Mock TasksDataSource repo;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    // AddEditTaskPresenter presenter = new AddEditTaskPresenter(null, repo, view, true);
    @Test
    public void start() throws Exception {
        AddEditTaskPresenter presenter = new AddEditTaskPresenter(null, repo, view, true);

    }

    @Test
    public void saveTask() throws Exception {

    }

    @Test
    public void populateTask() throws Exception {

    }

    @Test
    public void onTaskLoaded() throws Exception {

    }

    @Test
    public void onDataNotAvailable() throws Exception {

    }

    @Test
    public void isDataMissing() throws Exception {

    }

}

/*
Issue01. init repo need a Context!
: mock a repo! (even the data is already a mock version)

Issue02. test all the public methods?
: No. start() method is an example


*/