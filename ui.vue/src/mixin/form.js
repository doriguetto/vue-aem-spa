import utility from "../utils";

export default {
  props: {
    data: {
      type: Object,
      default: () => {}
    },
  },
  data() {
    return {
      nextQuestion: {},
      nextQuestionId: ''
    }
  },
  methods: {
    processFormElement(event, formElement) {
      if (event.target.value === formElement.eq && formElement.eqNextRef) {
        this.nextQuestion = formElement.eqNextRef
      } else if (event.target.value < formElement.lt && formElement.ltNextRef) {
        this.nextQuestion = formElement.ltNextRef
      } else if (event.target.value > formElement.gt && formElement.gtNextRef) {
        this.nextQuestion = formElement.gtNextRef
      } else {
        this.nextQuestion = {}
      }
    },
  },
  computed: {
    id() {
      return utility.generateId()
    },
    elementName() {
      return this.data.variableName ? this.data.variableName : this.id
    }
  },
  watch: {
    data: function () {
      this.reset()
      this.nextQuestion = {}
    }
  }
}
