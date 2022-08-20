title = "This is the title"

number_list = {}

table.insert(number_list, 1)
table.insert(number_list, 2)
table.insert(number_list, 3)
table.insert(number_list, {6})
table.insert(number_list, 5)

object_list = {}

o1 = {1}
table.insert(object_list, o1[0])
table.insert(object_list, {2})
table.insert(object_list, {3})
table.insert(object_list, 4)
table.insert(object_list, number_list)