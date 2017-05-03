/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ca.six.todo.taskdetail;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import ca.six.todo.data.Task;
import ca.six.todo.data.source.TasksDataSource;
import ca.six.todo.data.source.TasksRepository;

import com.google.common.base.Strings;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Listens to user actions from the UI ({@link TaskDetailFragment}), retrieves the data and updates
 * the UI as required.
 */
public class TaskDetailPresenter implements TaskDetailContract.Presenter {

    private final TasksRepository tasksRepository;

    private final TaskDetailContract.View taskDetailView;

    @Nullable
    private String mTaskId;

    public TaskDetailPresenter(@Nullable String taskId,
                               @NonNull TasksRepository tasksRepository,
                               @NonNull TaskDetailContract.View taskDetailView) {
        mTaskId = taskId;
        this.tasksRepository = checkNotNull(tasksRepository, "tasksRepository cannot be null!");
        this.taskDetailView = checkNotNull(taskDetailView, "taskDetailView cannot be null!");

        this.taskDetailView.setPresenter(this);
    }

    @Override
    public void start() {
        openTask();
    }

    private void openTask() {
        if (Strings.isNullOrEmpty(mTaskId)) {
            taskDetailView.showMissingTask();
            return;
        }

        taskDetailView.setLoadingIndicator(true);
        tasksRepository.getTask(mTaskId, new TasksDataSource.GetTaskCallback() {
            @Override
            public void onTaskLoaded(Task task) {
                // The view may not be able to handle UI updates anymore
                if (!taskDetailView.isActive()) {
                    return;
                }
                taskDetailView.setLoadingIndicator(false);
                if (null == task) {
                    taskDetailView.showMissingTask();
                } else {
                    showTask(task);
                }
            }

            @Override
            public void onDataNotAvailable() {
                // The view may not be able to handle UI updates anymore
                if (!taskDetailView.isActive()) {
                    return;
                }
                taskDetailView.showMissingTask();
            }
        });
    }

    @Override
    public void editTask() {
        if (Strings.isNullOrEmpty(mTaskId)) {
            taskDetailView.showMissingTask();
            return;
        }
        taskDetailView.showEditTask(mTaskId);
    }

    @Override
    public void deleteTask() {
        if (Strings.isNullOrEmpty(mTaskId)) {
            taskDetailView.showMissingTask();
            return;
        }
        tasksRepository.deleteTask(mTaskId);
        taskDetailView.showTaskDeleted();
    }

    @Override
    public void completeTask() {
        if (Strings.isNullOrEmpty(mTaskId)) {
            taskDetailView.showMissingTask();
            return;
        }
        tasksRepository.completeTask(mTaskId);
        taskDetailView.showTaskMarkedComplete();
    }

    @Override
    public void activateTask() {
        if (Strings.isNullOrEmpty(mTaskId)) {
            taskDetailView.showMissingTask();
            return;
        }
        tasksRepository.activateTask(mTaskId);
        taskDetailView.showTaskMarkedActive();
    }

    private void showTask(@NonNull Task task) {
        String title = task.getTitle();
        String description = task.getDescription();

        if (Strings.isNullOrEmpty(title)) {
            taskDetailView.hideTitle();
        } else {
            taskDetailView.showTitle(title);
        }

        if (Strings.isNullOrEmpty(description)) {
            taskDetailView.hideDescription();
        } else {
            taskDetailView.showDescription(description);
        }
        taskDetailView.showCompletionStatus(task.isCompleted());
    }
}
