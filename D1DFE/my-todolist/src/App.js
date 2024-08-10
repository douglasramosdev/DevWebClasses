import React, { useState } from 'react';
import './App.css';

function App() {
  const [task, setTask] = useState(''); 
  const [taskList, setTaskList] = useState([]); 

  const addTask = () => {
    if (task.trim()) {
      setTaskList([...taskList, task]);
      setTask(''); 
    }
  };

  const removeTask = (index) => {
    setTaskList(taskList.filter((_, i) => i !== index));
  };

  return (
    <div className="app">
      <input 
        type="text" 
        placeholder="Digite uma tarefa" 
        value={task} 
        onChange={(e) => setTask(e.target.value)}
      />
      <button onClick={addTask}>+</button>
      <ul>
        {taskList.map((item, index) => (
          <li key={index}>
            {item} 
            <button onClick={() => removeTask(index)}>Remover</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
