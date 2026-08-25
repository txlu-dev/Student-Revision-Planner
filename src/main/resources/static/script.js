async function loadTasks() {

    const response = await fetch("/api/tasks");

    const tasks = await response.json();

    const list = document.getElementById("taskList");

    list.innerHTML = "";

	tasks.forEach(task => {

	    const li = document.createElement("li");

	    if (task.completed) {

	        li.innerHTML = `

	            <span style="text-decoration: line-through;">

	                ✓ ${task.title}

	            </span>

	            <button onclick="deleteTask(${task.id})">

	                Delete

	            </button>

	        `;

	    } else {

	        li.innerHTML = `

	            ${task.title}

	            <button onclick="completeTask(${task.id})">

	                Complete

	            </button>

	            <button onclick="deleteTask(${task.id})">

	                Delete

	            </button>

	        `;

	    }

	    list.appendChild(li);

	});

}


async function addTask() {

    const input = document.getElementById("taskInput");

    const title = input.value;

    if (title.trim() === "") {

        return;

    }

    await fetch("/api/tasks", {

        method: "POST",

        headers: {

            "Content-Type": "application/json"

        },

        body: JSON.stringify({

            title: title

        })

    });

    input.value = "";

    loadTasks();

}


async function completeTask(id) {

    await fetch(`/api/tasks/${id}/complete`, {

        method: "PUT"

    });

    loadTasks();

}


async function deleteTask(id) {

    await fetch(`/api/tasks/${id}`, {

        method: "DELETE"

    });

    loadTasks();

}


loadTasks();