with open("drug_names lower.txt", "r") as reader:
    lines = reader.readlines()

no_comma = []
for x in lines:
    if(not ("," in x or "." in x or "-" in x or "/" in x or "first aid" in x)):
        no_comma.append(x)

print(len(lines))
print(len(no_comma))


with open("drug_names lower trimmed1.txt","a") as writer:
    for x in no_comma:
        writer.write(x)