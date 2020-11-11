<template>
  <div>
    <div class="form-group">
      <label :for="id">{{data.label}}</label>
      <input v-model="value" type="textfield" class="form-control" :name="elementName" :id="id" @input="onInput($event,data)">
    </div>
    <app-question :data="nextQuestion"></app-question>
  </div>
</template>

<script>

  import formMixin from '../../mixin/form'

  export default {
    mixins: [formMixin],
    data() {
      return {
        value: this.data.value
      }
    },
    methods: {
      onInput($event, data) {
        if (data.answers && data.answers.length === 1) {
            this.processFormElement($event,data.answers[0])
        }
      },
      reset() {
        this.value = this.data.value
      }
    }
  }

</script>

<style lang="scss">
  @import "~bootstrap/scss/forms";
  @import "~bootstrap/scss/custom-forms";
</style>
