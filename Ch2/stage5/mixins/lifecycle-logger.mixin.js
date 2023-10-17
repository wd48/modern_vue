export default {
    created () {
        console.log(`[stage5 mixins] ${this.$options.name} created`)
    },
    beforeMount () {
        console.log(`[stage5 mixins] ${this.$options.name} about to mount`)
    },
    mounted () {
        console.log(`[stage5 mixins] ${this.$options.name} mounted`)
    },
    destroyed () {
        console.log(`[stage5 mixins] ${this.$options.name} destroyed`)
    }
}