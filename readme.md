# Message Board

> A simple Java Web backend service.

## Using

- Springboot
- Dubbo
- Mybatis-Plus

## Architecture

- Interface
  > IDL for using Dubbo2.
- Api
  > Gateway of total service. There are 2 api in this project is that `/Message/list` and `/Message/add` 
- Message
  > Service of Message. It's a simple CRUD service.
