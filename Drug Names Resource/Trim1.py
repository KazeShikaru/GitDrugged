with open("drug_names.txt", "r") as reader:
    lines = reader.readlines()

lower = []
for x in lines:
    lower.append(x.lower())

print(len(lower))
lower = list(dict.fromkeys(lower))
print(len(lower))

with open("drug_names lower.txt", "a") as writer:
    for x in lower:
        writer.write(x)