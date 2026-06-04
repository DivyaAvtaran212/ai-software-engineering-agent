import { Link } from "react-router-dom";

function Sidebar() {
  return (
    <div className="w-64 h-screen bg-gray-900 text-white p-4">
      <h2 className="text-xl font-bold mb-6">
        AI Agent
      </h2>

      <nav className="flex flex-col gap-4">
        <Link to="/dashboard">Dashboard</Link>

        <Link to="/repositories">
          Repositories
        </Link>

        <Link to="/chat">
          Chat
        </Link>

        <Link to="/settings">
          Settings
        </Link>
      </nav>
    </div>
  );
}

export default Sidebar;