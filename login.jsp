<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            background-color: #363636; /* Gray background */
            color: #FFFFFF; /* White text */
            text-align: center;
            font-family: Arial, sans-serif;
        }

        h1 {
            color: #FFFF00; /* Yellow text */
            font-size: 32px;
        }

        h2 {
            color: #00FF00; /* Green text */
            font-size: 24px;
        }

        h3 {
            color: #FF0000; /* Red text */
            font-size: 20px;
        }

        label {
            color: #FFFF00; /* Yellow text */
        }

        input {
            background-color: #FFFFFF; /* White background for input fields */
            color: #000000; /* Black text in input fields */
        }

        button {
            background-color: #00FF00; /* Green button background */
            color: #000000; /* White button text */
            margin: 5px;
            padding: 5px 10px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>Welcome to the Fall 2023 Project 4 Enterprise System</h1>
    <h2>A Servlet/JSP-based Multi-tiered Enterprise Application Using A Tomcat Container</h2>
    <h3>~User Authentication Page~</h3>

    <form id="loginForm">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <!-- Buttons for each role -->
        <button type="button" onclick="authenticate('root')">Login as Root</button>
        <button type="button" onclick="authenticate('client')">Login as Client</button>
        <button type="button" onclick="authenticate('dataentryuser')">Login as Data Entry User</button>
        <button type="button" onclick="authenticate('accountant')">Login as Accountant</button>


    </form>

    <script>
        function authenticate(role) {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;


            var validCredentials = {
                "root": "pass1",
                "client": "client",
                "dataentryuser": "dataentryuser",
                "accountant": "accountant"
            };

            if (validCredentials[role] === password) {
                window.location.href = role + ".jsp"; // Redirect to the specific JSP page
            } else {
                window.location.href = "error.jsp"; // Redirect to the error page
            }
        }
    </script>
</body>
</html>
