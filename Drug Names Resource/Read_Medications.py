import re
with open("drug_list.json", "r") as file:
    alllist = file.readlines()

string = ""
#for x in all:
#    print(x)

# count = 0
# hundred = ""
# while(count < 10000):
#     hundred += all[count]
#     count += 1
all = ""
for x in alllist:
    all += x

result = re.findall("generic_name\": \"(.*)\"",all)
# print(result)
result = list(dict.fromkeys(result))
with open("drug_names.txt", "a") as file:
    for x in result:
        file.write(x + "\n")