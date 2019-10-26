# lightning-lambdas-demo

Watch how quickly and easily a Lambda can be created, tested and deployed to AWS. We create a Lambda that is triggered each time a file is added to an S3 Bucket. We load application config for different environments, query Dynamo DB and write to S3. We write some tests and create a pull request. Finally we deploy a cloudformation stack (including the datastores, triggers, IAM roles etc) test it manually and tear it down again. All in minutes not weeks.
