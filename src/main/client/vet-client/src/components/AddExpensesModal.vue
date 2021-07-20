<template>
  <div class="popup">
    <div class="popup-inner">
      <slot />
      <button class="popup-close" @click="$emit('close-add-expenses')">
        Close
      </button>
    </div>
  </div>
  
</template>

<script>
export default {
  name: 'AddExpensesModal'
}
</script>

<style scoped>
  .popup {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    z-index: 99;
    background-color: rgba(0, 0, 0, 0, 1);
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .popup-inner {
    background: #7541D3;
    padding: 32px;
    border-radius: 10px;
    border: 5px solid black;
    color: black;
  }
</style>

