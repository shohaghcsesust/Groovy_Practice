package misc

def text ='This Tutorial focuses on $TutorialName. In this tutorial you will learn about $Topic'

def binding = ["TutorialName":"Groovy", "Topic":"Templates"]
def engine = new groovy.text.SimpleTemplateEngine()
def template = engine.createTemplate(text).make(binding)

println template


text = '''This Tutorial is <% out.print TutorialName %> The Topic name

is ${TopicName}''' 
template = new groovy.text.StreamingTemplateEngine().createTemplate(text)
  
binding = [TutorialName : "Groovy", TopicName  : "Templates",]
String response = template.make(binding)
println(response)

binding = [StudentName: 'Joe', id: 1, subject: 'Physics']
engine = new groovy.text.XmlTemplateEngine()

text = '''\
   <document xmlns:gsp='http://groovy.codehaus.org/2005/gsp'>
      <Student>
         <name>${StudentName}</name>
         <ID>${id}</ID>
         <subject>${subject}</subject>
      </Student>
   </document> 
''' 

template = engine.createTemplate(text).make(binding)
println template.toString()