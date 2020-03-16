import React, { useState } from "react";
import axios from 'axios';

import './SimulationForm.css';

function SimulationForm () {

  const [simulationData, setSimulationData] = useState(null);

  function handleSubmit(event) {
    event.preventDefault();
    const iterations = event.target.iterations.value
    const switchdoors = event.target.switchdoors.checked
    axios.get(`simulation?iterations=${iterations}&switchDoors=${switchdoors}`)
      .then(res => {
        setSimulationData(res.data)
      })
  }

  return(
    <React.Fragment>
      <form className="App-form" onSubmit={event => handleSubmit(event)}>
        <label>Iterations</label>
        <input type="number" name="iterations" required min="1" className="App-iterations"/>
        <label>Change door</label>
        <input type="checkbox" name="switchdoors" className="App-switchdoors"/>
        <button type="submit">Submit</button>
      </form>
      {simulationData && <h3 className="App-results">WIN RATE: {Math.round((simulationData.wins/simulationData.iterations) * 100)} %</h3>}
    </React.Fragment>
  )
}

export default SimulationForm;