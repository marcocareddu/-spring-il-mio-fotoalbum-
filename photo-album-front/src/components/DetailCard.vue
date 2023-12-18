<script setup>
import { defineProps, defineEmits } from 'vue';
import axios from 'axios';

// Props
const props = defineProps({
	photo: {
		type: Object,
		required: true
	}
});

console.log(props.photo);

// Emits
const emits = defineEmits(['listphoto']);

// Consts and vars
const newMessage = {
	email: '',
	message: '',
};

const sendMessage = async () => {
        const response = await axios.post(
            'http://localhost:8080/api/v1.0/messages', newMessage);
		console.log(response);
};
</script>

<template>
	<div class="card col-6 mt-5 p-0">
		<img :src="photo.url" class="card-img-top img-fluid">
		<div class="card-body text-center">
			<h4 class="card-title"><i class="fa-solid fa-camera-retro text-primary"></i> {{ photo.title }}</h4>
			<p class="card-text">{{ photo.description }}</p>

			<!-- Categories -->
			<div>
				<h6 class="card-title mt-4">Categorie</h6>
				<span v-for="category in photo.categories" :key="category.id" class="card-text my-2">{{ category.name }}
				</span>
			</div>

			<!-- Single Card Buttons-->
			<div class="d-flex justify-content-center">
				<div class="m-2">
					<button @click="$emit('listphoto', true)" class="me-2 btn btn-primary">Torna alla lista</button>
				</div>
			</div>
		</div>

		<!-- Message form -->
		<form action="POST" @submit.prevent="sendMessage">
			<div class="my-5">
				<div class="d-flex justify-content-center mb-5">
					<h1> Invia un messaggio</h1>
				</div>


				<div class="input-group mb-3">
					<span class="input-group-text" id="email">Email</span>
					<input type="email" class="form-control" v-model="newMessage.email" placeholder="Indirizzo email">
				</div>

				<div class="input-group">
					<span class="input-group-text">Messaggio</span>
					<textarea v-model="newMessage.message" class="form-control" placeholder="Messaggio..."></textarea>
				</div>

				<div class="d-flex justify-content-end">
					<button class="btn btn-primary">Invia</button>
				</div>
			</div>
		</form>
	</div>
</template>