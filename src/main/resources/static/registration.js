document
    .getElementById("registrationForm")
    .addEventListener("submit", function (event) {

        event.preventDefault();

        const username =
            document.getElementById("username").value;

        const password =
            document.getElementById("password").value;

        const role =
            document.getElementById("role").value;

        const message =
            document.getElementById("message");


        fetch("/skyline/register", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({

                username: username,
                password: password,
                role: role

            })

        })

            .then(response => response.text())

            .then(result => {

                message.innerText = result;

                if (result === "Registration successful") {

                    message.style.color = "green";

                    document
                        .getElementById("registrationForm")
                        .reset();

                } else {

                    message.style.color = "red";

                }

            })

            .catch(error => {

                console.error(error);

                message.innerText =
                    "Something went wrong";

                message.style.color = "red";

            });

    });