function Login() {

  const githubLogin = () => {

    window.location.href =
      "http://localhost:8080/oauth2/authorization/github";
  };

  return (
    <div className="flex items-center justify-center h-screen">

      <button
        onClick={githubLogin}
        className="bg-black text-white px-6 py-3 rounded"
      >
        Continue with GitHub
      </button>

    </div>
  );
}

export default Login;