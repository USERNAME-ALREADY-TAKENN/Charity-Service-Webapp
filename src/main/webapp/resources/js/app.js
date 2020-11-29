document.addEventListener("DOMContentLoaded", function() {

  let first_run = true;

  /**
   * Form Select
   */
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      // Input for value
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      // Dropdown container
      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      // List container
      this.ul = document.createElement("ul");

      // All list options
      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          // First clickable option
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        // Save new value only when clicked on li
        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }
  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  /**
   * Hide elements when clicked on document
   */
  document.addEventListener("click", function(e) {
    const target = e.target;
    const tagName = target.tagName;

    if (target.classList.contains("dropdown")) return false;

    if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
      return false;
    }

    if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
      return false;
    }

    document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
      el.classList.remove("selecting");
    });
  });

  /**
   * Switching between form steps
   */
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();
    }

    /**
     * Init all methods
     */
    init() {
      this.events();
      this.updateForm();
    }

    /**
     * All events that are happening in form
     */
    events() {
      // Next step
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          if(this.updateForm()) {
            this.currentStep++;
          }
        });
      });

      // Previous step
      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          if(this.updateForm()) {
            this.currentStep--;
          }
        });
      });

      // Form submit
      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    /**
     * Update form front-end
     * Show next or previous section etc.
     */
    updateForm() {
      this.$step.innerText = this.currentStep;

      // Data validation
      console.log(first_run);
      if(!first_run) {
        first_run = true;
        if (this.currentStep === 1 && document.querySelector('input[type="checkbox"]:checked') == null) {
          console.log("1");
          document.querySelector('#categories-errors').innerHTML = "<h3>Musisz zaznaczyć przynajmniej 1 pole!</h3>";
          first_run = false;
          return false;
        }
        if(this.currentStep === 2 && isNaN(document.querySelector('#quantity').value) || document.querySelector('#quantity').value < 1) {
          console.log("2");
          document.querySelector('#quantity-errors').innerHTML = "<h3>Wartość musi być liczbą oraz musi być większa od 0!</h3>";
          first_run = false;
          return false;
        }
      }
      console.log("dupa");
      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;

      // get data from inputs and show them in summary
      document.getElementById("quantityFinal").innerText = document.getElementById("quantity").value;
      document.getElementById("streetFinal").innerText = document.getElementById("street").value;
      document.getElementById("zipCodeFinal").innerText = document.getElementById("zipCode").value;
      document.getElementById("cityFinal").innerText = document.getElementById("city").value;
      document.getElementById("pickUpDateFinal").innerText = document.getElementById("pickUpDate").value;
      document.getElementById("pickUpTimeFinal").innerText = document.getElementById("pickUpTime").value;
      document.getElementById("pickUpCommentFinal").innerText = document.getElementById("pickUpComment").value;
      let checked_institution = document.querySelector('input[name="institution"]:checked');
      if(checked_institution) {
        document.getElementById("institutionFinal").innerText = checked_institution.nextElementSibling.nextElementSibling.children[0].innerText;
      }
      document.getElementById("categoryFinal").innerText = Array.from(document.querySelectorAll('input[name="categories"]:checked')).map(el => {return el.nextElementSibling.nextElementSibling.innerText;}).join(", ")

      first_run = false;
      return true;
    }

  }
  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }
});
