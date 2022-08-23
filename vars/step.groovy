def method1() {
    def someVar

    result = method2(someVar)

    if (result) {
        return 'ok'
    }
    else {
        return 'no'
    }
}

def method2(value) {

    if (value == 1) {
        return true
    }
    else {
        return false
    }
}