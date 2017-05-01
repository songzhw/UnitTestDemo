
package ca.six.todo.addedittask;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ca.six.todo.data.Task;
import ca.six.todo.data.source.TasksDataSource;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AddEditTaskPresenterTest {
    @Mock AddEditTaskContract.View view;
    @Mock TasksDataSource repo;
    @Captor ArgumentCaptor<TasksDataSource.GetTaskCallback> captor;

    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        when(view.isActive()).thenReturn(true);
    }

    @Test
    public void createTask_setPresenterToView() throws Exception {
        AddEditTaskPresenter presenter = new AddEditTaskPresenter(null, repo, view, true);
        verify(view).setPresenter(presenter);
    }

    // ========================= Create New Page =========================

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

//        Task task = new Task(TITLE, DESCRIPTION);//=> 会fail掉测试。 因为生成的id是随机的
        verify(repo).saveTask(any(Task.class));
        verify(view).showTasksList();
    }


    // ========================= Edit Task Page =========================
    @Test
    public void editTask_populateTaskFailed(){
        AddEditTaskPresenter presenter = new AddEditTaskPresenter("1000", repo, view, true);
        presenter.start();

        verify(repo).getTask(eq("1000"), captor.capture());
        captor.getValue().onDataNotAvailable();
        verify(view).showEmptyTaskError();
    }


    @Test
    public void editTask_puluateTaskSucc(){
        AddEditTaskPresenter presenter = new AddEditTaskPresenter("1000", repo, view, true);
        presenter.start();

        verify(repo).getTask(eq("1000"), captor.capture());
        captor.getValue().onTaskLoaded(new Task(TITLE, DESCRIPTION));

        verify(view).setTitle(TITLE);
        verify(view).setDescription(DESCRIPTION);
        assertFalse(presenter.isDataMissing());
    }

    @Test
    public void editTask_updateAndSave(){
        AddEditTaskPresenter presenter = new AddEditTaskPresenter("1000", repo, view, true);
        presenter.saveTask(TITLE, DESCRIPTION);

        Task task = new Task(TITLE, DESCRIPTION, "1000");
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
: 实践证明，可以用TaskRepo的！ 而且我感觉因为TaskRepo是接口，其实更好Mock, 是更好的选择。

Issue04: create new task failed in the test:
        Task task = new Task(TITLE, DESCRIPTION);
        verify(repo).saveTask(task)
: Erro Info : "Argument(s) are different". Because the ID is different!
Then how to solve it?
: use "any(Task.class)"
  或者， src中 createTask()不是return void, 而是return Task;

*/
