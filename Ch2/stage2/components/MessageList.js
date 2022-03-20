export default {
    name: 'MessageList',
    template: `<ul>
        <li v-for="item in items" :item="item">
        {{ item.text }} - {{ item.createdAt }}
        <button @click="deleteMessage(item)">X</button></li></ul>`,
    props: {
        items: {
            type: Array,
            required: true
        }
    },
    methods: {
        deleteMessage(message) {
            this.$emit('delete', message);
        }
    }
}
/**
 * ES6 모듈
 * 
 * 컴포넌트를 정의하는 options 객체를 기본 내보내기로 내보낸다.
 * 
 * line 14: Delete click 이벤트 수신을 위해 deleteMessage() 메소드 추가
 * > $emit() : MessageList의 delete 이벤트를 트리거한다
 */