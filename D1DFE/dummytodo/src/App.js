import React, { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [todos, setTodos] = useState([]);
  const [newTodo, setNewTodo] = useState(''); 

  
  useEffect(() => {
    fetch('https://dummyjson.com/todos')
      .then(response => response.json())
      .then(data => setTodos(data.todos))
      .catch(error => console.error('Erro ao buscar dados:', error));
  }, []);


  const toggleComplete = (id) => {
    setTodos(
      todos.map(todo =>
        todo.id === id ? { ...todo, completed: !todo.completed } : todo
      )
    );
  };

  const addTodo = () => {
    if (newTodo.trim() === '') return; 

    const newTask = {
      id: todos.length + 1, 
      todo: newTodo,
      completed: false,
    };

    setTodos([...todos, newTask]);
    setNewTodo('');
  };

  const removeTodo = (id) => {
    setTodos(todos.filter(todo => todo.id !== id));
  };

  return (
    <div className="container mt-5">
      <h1 className="text-center">ToDo List</h1>
      <div className="mb-3">
        <input
          type="text"
          className="form-control"
          placeholder="Digite uma nova tarefa"
          value={newTodo}
          onChange={(e) => setNewTodo(e.target.value)}
        />
        <button className="btn btn-primary mt-2" onClick={addTodo}>
          Adicionar Tarefa
        </button>
      </div>
      <ul className="list-group">
        {todos.map(todo => (
          <li
            key={todo.id}
            className={`list-group-item d-flex justify-content-between align-items-center ${todo.completed ? 'completed' : ''}`}
          >
            <span style={{ textDecoration: todo.completed ? 'line-through' : 'none' }}>
              {todo.todo}
            </span>
            <div>
              <button
                className="btn btn-success me-2"
                onClick={() => toggleComplete(todo.id)}
              >
                {todo.completed ? 'Desmarcar' : 'Completar'}
              </button>
              <button
                className="btn btn-danger"
                onClick={() => removeTodo(todo.id)}
              >
                Remover
              </button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;

