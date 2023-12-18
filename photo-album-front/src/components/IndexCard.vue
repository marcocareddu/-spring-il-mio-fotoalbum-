<script setup>
import { defineProps } from 'vue';

// Emits
const emits = ['single-photo'];

// Props
const props = defineProps({
  photo: {
    type: Object,
    required: true
  }
});
</script>

<template>
    <div class="card col m-3 indexCard" style="width: 18rem; padding: 0;">
        <img :src="photo.url" class="card-img-top multi-img">
        <div class="card-body d-flex flex-column">
            <h5 class="card-title"><i class="fa-solid fa-camera-retro text-primary"></i> {{ photo.title }}</h5>
            <p class="card-text flex-grow-1">{{ photo.description }}</p>
            <div class="mt-auto d-flex justify-content-center">
                <div class="me-2">
                    <button @click="$emit('single-photo', photo)" class="btn btn-primary">Dettaglio</button>
                </div>
            </div>
        </div>
    </div>
</template>