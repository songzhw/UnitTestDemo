
package ca.six.todo.addedittask;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ca.six.todo.Injection;
import ca.six.todo.data.Task;
import ca.six.todo.data.source.TasksDataSource;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class AddEditTaskPresenterTest {
    @Mock AddEditTaskContract.View view;
    @Mock TasksDataSource repo;

    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void createTask_showEmptyView() throws Exception {
        AddEditTaskPresenter presenter = new AddEditTaskPresenter(null, repo, view, true);
        // do nothing. so it's not testable
    }

    @Test
    public void createAndSaveEmptyTask_showError() throws Exception {
        // taskId is null, so it is creating a new task
        AddEditTaskPresenter presenter = new AddEditTaskPresenter(null, repo, view, true);
        presenter.saveTask("", "");

        verify(view).showEmptyTaskError();
    }

    @Test
    public void createAndSaveTask_returnBackWithNewTask() throws Exception {
        // taskId is null, so it is creating a new task
        AddEditTaskPresenter presenter = new AddEditTaskPresenter(null, repo, view, true);
        presenter.saveTask(TITLE, DESCRIPTION);

        Task task = new Task(TITLE, DESCRIPTION);
        verify(repo).saveTask(task);
        verify(view).showTasksList();
    }

}

/*
Issue01. init repo need a Context!
: mock a repo! (even the data is already a mock version)

Issue02. test all the public methods?
: No. start() method is an example

Issue03. why mock TaskRepo, not TaskSource in the sample?
:

Issue04: create new task failed in the test:
        Task task = new Task(TITLE, DESCRIPTION);
        verify(repo).saveTask(task)
: Erro Info : "Argument(s) are different". Because the ID is different!
Then how to solve it?
: 

*/
