<template>

<nav class="navbar navbar-expand-lg navbar-light" id="navbar">
        <button class="navbar-toggler" id="toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="form-group">
                    <label for="inputEmail" id="label">Email address</label>
                    <input type="email" class="form-control" id="inputEmail" aria-describedby="emailHelp" placeholder="Enter email" v-model="email">
            </div>
            <div class="form-group" id="password">
                    <label for="inputPassword" id="label">Password</label>
                    <input type="password" class="form-control" id="inputPassword" placeholder="Password"  v-model="password">
            </div>            
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active" id="menu-item-wrapper">
                    <router-link class="nav-link" id="menu-item" @click="login" to="/user">Log in <span class="sr-only"></span></router-link>
                </li>
            </ul>
        </div>
</nav>
    
</template>

<script>
export default {
    name: "LogInNavBar",
    data() {
        return {
            email: '',
            password: ''
        }
    },
    methods: {
        //just some hardcoded basic login to fiddle with routing
        login() {
            if (this.email === "example@animaclinic.com" && this.password === "admin") 
            {
                console.log("Logged in.")
            } else 
            {
                alert("Incorrect email and/or password.")
                this.$router.push('/')
            }
        }
    }
}
</script>

<style scoped>
    #menu-item {
        color: whitesmoke;
        text-align: center;
        font-size: 1.5rem;
    }
    #menu-item:hover {
        transition: 0.4s;
        color: #7541D3;
        cursor: pointer;
    }
    #menu-item-wrapper {
        padding: 1rem;
    }
    #navbar {
        background: linear-gradient(to top, transparent, black, 10%, black);
        justify-content: end ;
    }
    #toggler {
        background-color: whitesmoke;
    }
    #navbarSupportedContent {
        justify-content: center;
    }
    #password {
        margin-left: 1rem;
    }
    #label {
        color: whitesmoke;
    }
</style>