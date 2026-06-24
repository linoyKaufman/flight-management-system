import { useEffect, useState } from "react";
import axios from "axios";

type Flight = {
  id: number;
  flightCode: string;
  destination: string;
  price: number;
  cancelled: boolean;
};

function App() {
  const [flights, setFlights] = useState<Flight[]>([]);
  const [flightCode, setFlightCode] = useState("");
  const [destination, setDestination] = useState("");
  const [price, setPrice] = useState("");

  const fetchFlights = () => {
    axios
      .get("http://localhost:8080/api/flights")
      .then((response) => setFlights(response.data))
      .catch((error) => console.error(error));
  };

  useEffect(() => {
    fetchFlights();
  }, []);

  const addFlight = async (event: React.FormEvent) => {
    event.preventDefault();

    await axios.post("http://localhost:8080/api/flights", {
      flightCode,
      cancelled: false,
      price: Number(price),
      departureTime: 900,
      landingTime: 1300,
      destination,
    });

    setFlightCode("");
    setDestination("");
    setPrice("");
    fetchFlights();
  };

  const deleteFlight = async (id: number) => {
  await axios.delete(`http://localhost:8080/api/flights/${id}`);
  fetchFlights();
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>Flight Management System</h1>

      <form onSubmit={addFlight} style={{ marginBottom: "20px" }}>
        <input
          placeholder="Flight Code"
          value={flightCode}
          onChange={(e) => setFlightCode(e.target.value)}
        />

        <input
          placeholder="Destination"
          value={destination}
          onChange={(e) => setDestination(e.target.value)}
        />

        <input
          placeholder="Price"
          type="number"
          value={price}
          onChange={(e) => setPrice(e.target.value)}
        />

        <button type="submit">Add Flight</button>
      </form>

      <table border={1} cellPadding={10}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Flight Code</th>
            <th>Destination</th>
            <th>Price</th>
            <th>Cancelled</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {flights.map((flight) => (
            <tr key={flight.id}>
  <td>{flight.id}</td>
  <td>{flight.flightCode}</td>
  <td>{flight.destination}</td>
  <td>{flight.price}</td>
  <td>{flight.cancelled ? "Yes" : "No"}</td>

  <td>
    <button onClick={() => deleteFlight(flight.id)}>
      Delete
    </button>
  </td>
</tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;