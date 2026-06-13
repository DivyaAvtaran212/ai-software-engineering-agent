import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "../pages/Home";
import Login from "../pages/Login";
import Dashboard from "../pages/Dashboard";
import Repositories from "../pages/Repositories";
import Chat from "../pages/Chat";
import Settings from "../pages/Settings";
import MainLayout from "../layouts/MainLayout";
import OAuthSuccess from "../pages/OAuthSuccess";

function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route element={<MainLayout />}>
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/repositories" element={<Repositories />} />
          <Route path="/chat" element={<Chat />} />
          <Route path="/settings" element={<Settings />} />
          <Route path="/oauth-success" element={<OAuthSuccess />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default AppRoutes;
