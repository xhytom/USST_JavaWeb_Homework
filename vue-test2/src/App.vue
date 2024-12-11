<template>

  <!-- <SlotsTwo>
    <template v-slot:slot1>
      <p>"A"</p>
    </template>
    <template v-slot:slot2>
      <p>"B"</p>
    </template>
  
  </SlotsTwo> -->

  <SlotsThree>
    <template #slot1="slotProps">
      <p>{{ slotProps.msg }}</p>
    </template>

    <template #slot2="slotProps">
      <p>{{ slotProps.demo }}</p>
    </template>
  </SlotsThree>

</template>


<script>
// import Parent from './components/myComponents/Parent.vue';
// import ComponentA from './components/myComponents/ComponentA.vue';
// import ComponentEvent from './components/ComponentEvent.vue';
// import Main from './components/Main.vue';
// import ComponentA from './components/ComponentA.vue';
// import SlotsBase from './components/SlotsBase.vue';
// import SlotsTwo from './components/SlotsTwo.vue';
import SlotsThree from './components/SlotsThree.vue';

export default {
  data() {
    return {
      message: "msg",
      currentTest:"测试内容",
    }
  },
  components: {
    // Parent,
    // ComponentA,
    // ComponentEvent,
    // Main,
    // SlotsBase,
    // SlotsTwo,
    SlotsThree,
  }
}

</script>

<style>

</style>





<!-- <template>
  <div>
    <Header />
    <Main />
    <Aside />
  </div>
</template> -->

<!-- <script> -->
<!-- // import Header from './pages/Header.vue';
import Main from './pages/Main.vue';
import Aside from './pages/Aside.vue';

export default {
  components: {
    // Header:Header,
    Main:Main,
    Aside:Aside
  }
} -->

<!-- </script> -->

<!-- <style> -->

<!-- </style> -->


<!-- <template> -->
  <!-- <MyComponents />
  <div class="container">123</div> -->
<!-- </template> -->

<!-- <script> -->

  <!-- import MyComponents from './components/myComponents/myComponents.vue';
  export default {
    components: {
      MyComponents: MyComponents
    }
  } -->

<!-- </script> -->


<!-- <script setup> -->
<!-- import HelloWorld from './components/HelloWorld.vue'
import IfDemo from './components/IfDemo.vue'
import ListDemo from './components/ListDemo.vue'
import KeyDemo from './components/KeyDemo.vue'
import EventDemo1 from './components/EventDemo1.vue'
import EventDemo2 from './components/EventDemo2.vue'
import EventDemo3 from './components/EventDemo3.vue'
import EventDemo4 from './components/EventDemo4.vue'
import EventDemo5 from './components/EventDemo5.vue'
import EventDemo6 from './components/EventDemo6.vue'
import ArrayList from './components/ArrayList.vue'
import ComputedDemo from './components/ComputedDemo.vue'
import ClassDemo from './components/ClassDemo.vue'
import StyleDemo from './components/StyleDemo.vue'
import WatchDemo from './components/WatchDemo.vue'
import ModelDemo from './components/ModelDemo.vue'
import RefDemo from './components/RefDemo.vue'
import RefDemo from './components/RefDemo.vue' -->

<!-- </script> -->

<!-- <template> -->
  <!-- <header> -->
    <!-- <HelloWorld /> -->
    <!-- <IfDemo /> -->
    <!-- <ListDemo /> -->
    <!-- <KeyDemo /> -->
    <!-- <EventDemo1 /> -->
    <!-- <EventDemo2 /> -->
    <!-- <EventDemo3 /> -->
    <!-- <EventDemo4 /> -->
    <!-- <EventDemo5 /> -->
    <!-- <EventDemo6 /> -->
    <!-- <ArrayList /> -->
    <!-- <ComputedDemo /> -->
    <!-- <ClassDemo /> -->
    <!-- <StyleDemo /> -->
    <!-- <WatchDemo /> -->
    <!-- <ModelDemo /> -->
    <!-- <RefDemo /> -->
    
  <!-- </header> -->

<!-- </template> -->
