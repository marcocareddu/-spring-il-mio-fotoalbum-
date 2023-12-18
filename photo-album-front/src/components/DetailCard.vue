<script setup>
import { defineProps, defineEmits } from 'vue';

// Props
const props = defineProps({
    photo: {
        type: Object,
        required: true
    }
});

// Emits
const emits = defineEmits(['listphoto', 'createForm']);

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
				<span v-for="category in photo.categories" :key="category.id" class="card-text my-2">{{ category.name }} </span>
			</div>

			<!-- Single Card Buttons-->
			<div class="d-flex justify-content-center">
				<div class="m-2">
                    <button @click="$emit('listphoto', true)" class="me-2 btn btn-primary">Torna alla lista</button>
				</div>
			</div>
		</div>
	</div>
</template>