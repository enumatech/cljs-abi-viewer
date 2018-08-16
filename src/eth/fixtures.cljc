(ns eth.fixtures)

(def oax-contract
  {:from "0x29a6feaB1Ff84F69E2b70F7b4AA1149706A35658",
   :gas 4000000,
   :name "DemoOAX",
   :address "0x475CDA4A73EE3f01748a9D553A8c19Ca2853A8Aa",
   :jsonInterface [{:constant true,
                    :inputs [],
                    :name "name",
                    :outputs [{:name "", :type "bytes32"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0x06fdde03"}
                   {:constant false,
                    :inputs [],
                    :name "stop",
                    :outputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0x07da68f5"}
                   {:constant false,
                    :inputs [{:name "guy", :type "address"} {:name "wad", :type "uint256"}],
                    :name "approve",
                    :outputs [{:name "", :type "bool"}],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0x095ea7b3"}
                   {:constant false,
                    :inputs [{:name "owner_", :type "address"}],
                    :name "setOwner",
                    :outputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0x13af4035"}
                   {:constant true,
                    :inputs [],
                    :name "totalSupply",
                    :outputs [{:name "", :type "uint256"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0x18160ddd"}
                   {:constant false,
                    :inputs [{:name "src", :type "address"}
                             {:name "dst", :type "address"}
                             {:name "wad", :type "uint256"}],
                    :name "transferFrom",
                    :outputs [{:name "", :type "bool"}],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0x23b872dd"}
                   {:constant true,
                    :inputs [],
                    :name "decimals",
                    :outputs [{:name "", :type "uint8"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0x313ce567"}
                   {:constant false,
                    :inputs [{:name "guy", :type "address"} {:name "wad", :type "uint256"}],
                    :name "mint",
                    :outputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0x40c10f19"}
                   {:constant false,
                    :inputs [{:name "wad", :type "uint256"}],
                    :name "burn",
                    :outputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0x42966c68"}
                   {:constant false,
                    :inputs [{:name "name_", :type "bytes32"}],
                    :name "setName",
                    :outputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0x5ac801fe"}
                   {:constant true,
                    :inputs [{:name "src", :type "address"}],
                    :name "balanceOf",
                    :outputs [{:name "", :type "uint256"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0x70a08231"}
                   {:constant true,
                    :inputs [],
                    :name "stopped",
                    :outputs [{:name "", :type "bool"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0x75f12b21"}
                   {:constant false,
                    :inputs [{:name "authority_", :type "address"}],
                    :name "setAuthority",
                    :outputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0x7a9e5e4b"}
                   {:constant true,
                    :inputs [],
                    :name "owner",
                    :outputs [{:name "", :type "address"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0x8da5cb5b"}
                   {:constant true,
                    :inputs [],
                    :name "symbol",
                    :outputs [{:name "", :type "bytes32"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0x95d89b41"}
                   {:constant false,
                    :inputs [{:name "guy", :type "address"} {:name "wad", :type "uint256"}],
                    :name "burn",
                    :outputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0x9dc29fac"}
                   {:constant false,
                    :inputs [{:name "wad", :type "uint256"}],
                    :name "mint",
                    :outputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0xa0712d68"}
                   {:constant false,
                    :inputs [{:name "dst", :type "address"} {:name "wad", :type "uint256"}],
                    :name "transfer",
                    :outputs [{:name "", :type "bool"}],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0xa9059cbb"}
                   {:constant false,
                    :inputs [{:name "dst", :type "address"} {:name "wad", :type "uint256"}],
                    :name "push",
                    :outputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0xb753a98c"}
                   {:constant false,
                    :inputs [{:name "src", :type "address"}
                             {:name "dst", :type "address"}
                             {:name "wad", :type "uint256"}],
                    :name "move",
                    :outputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0xbb35783b"}
                   {:constant false,
                    :inputs [],
                    :name "start",
                    :outputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0xbe9a6555"}
                   {:constant true,
                    :inputs [],
                    :name "authority",
                    :outputs [{:name "", :type "address"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0xbf7e214f"}
                   {:constant false,
                    :inputs [{:name "guy", :type "address"}],
                    :name "approve",
                    :outputs [{:name "", :type "bool"}],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0xdaea85c5"}
                   {:constant true,
                    :inputs [{:name "src", :type "address"} {:name "guy", :type "address"}],
                    :name "allowance",
                    :outputs [{:name "", :type "uint256"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0xdd62ed3e"}
                   {:constant false,
                    :inputs [{:name "src", :type "address"} {:name "wad", :type "uint256"}],
                    :name "pull",
                    :outputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0xf2d5d56b"}
                   {:inputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "constructor",
                    :signature "constructor"}
                   {:anonymous false,
                    :inputs [{:indexed true, :name "guy", :type "address"}
                             {:indexed false, :name "wad", :type "uint256"}],
                    :name "Mint",
                    :type "event",
                    :signature "0x0f6798a560793a54c3bcfe86a93cde1e73087d944c0ea20544137d4121396885"}
                   {:anonymous false,
                    :inputs [{:indexed true, :name "guy", :type "address"}
                             {:indexed false, :name "wad", :type "uint256"}],
                    :name "Burn",
                    :type "event",
                    :signature "0xcc16f5dbb4873280815c1ee09dbd06736cffcc184412cf7a71a0fdb75d397ca5"}
                   {:anonymous false,
                    :inputs [{:indexed true, :name "authority", :type "address"}],
                    :name "LogSetAuthority",
                    :type "event",
                    :signature "0x1abebea81bfa2637f28358c371278fb15ede7ea8dd28d2e03b112ff6d936ada4"}
                   {:anonymous false,
                    :inputs [{:indexed true, :name "owner", :type "address"}],
                    :name "LogSetOwner",
                    :type "event",
                    :signature "0xce241d7ca1f669fee44b6fc00b8eba2df3bb514eed0f6f668f8f89096e81ed94"}
                   {:anonymous true,
                    :inputs [{:indexed true, :name "sig", :type "bytes4"}
                             {:indexed true, :name "guy", :type "address"}
                             {:indexed true, :name "foo", :type "bytes32"}
                             {:indexed true, :name "bar", :type "bytes32"}
                             {:indexed false, :name "wad", :type "uint256"}
                             {:indexed false, :name "fax", :type "bytes"}],
                    :name "LogNote",
                    :type "event",
                    :signature "0x644843f351d3fba4abcd60109eaff9f54bac8fb8ccf0bab941009c21df21cf31"}
                   {:anonymous false,
                    :inputs [{:indexed true, :name "src", :type "address"}
                             {:indexed true, :name "guy", :type "address"}
                             {:indexed false, :name "wad", :type "uint256"}],
                    :name "Approval",
                    :type "event",
                    :signature "0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"}
                   {:anonymous false,
                    :inputs [{:indexed true, :name "src", :type "address"}
                             {:indexed true, :name "dst", :type "address"}
                             {:indexed false, :name "wad", :type "uint256"}],
                    :name "Transfer",
                    :type "event",
                    :signature "0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"}]})

(def weth-contract
  {:from "0xd124b979F746bE85706DaA1180227e716EafCc5c",
   :gas 4000000,
   :name "WETH9",
   :address "0x682c9a15661923d1683B7a5740A410D92530053D",
   :jsonInterface [{:constant true,
                    :inputs [],
                    :name "name",
                    :outputs [{:name "", :type "string"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0x06fdde03"}
                   {:constant false,
                    :inputs [{:name "guy", :type "address"} {:name "wad", :type "uint256"}],
                    :name "approve",
                    :outputs [{:name "", :type "bool"}],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0x095ea7b3"}
                   {:constant true,
                    :inputs [],
                    :name "totalSupply",
                    :outputs [{:name "", :type "uint256"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0x18160ddd"}
                   {:constant false,
                    :inputs [{:name "src", :type "address"}
                             {:name "dst", :type "address"}
                             {:name "wad", :type "uint256"}],
                    :name "transferFrom",
                    :outputs [{:name "", :type "bool"}],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0x23b872dd"}
                   {:constant false,
                    :inputs [{:name "wad", :type "uint256"}],
                    :name "withdraw",
                    :outputs [],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0x2e1a7d4d"}
                   {:constant true,
                    :inputs [],
                    :name "decimals",
                    :outputs [{:name "", :type "uint8"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0x313ce567"}
                   {:constant true,
                    :inputs [{:name "", :type "address"}],
                    :name "balanceOf",
                    :outputs [{:name "", :type "uint256"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0x70a08231"}
                   {:constant true,
                    :inputs [],
                    :name "symbol",
                    :outputs [{:name "", :type "string"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0x95d89b41"}
                   {:constant false,
                    :inputs [{:name "dst", :type "address"} {:name "wad", :type "uint256"}],
                    :name "transfer",
                    :outputs [{:name "", :type "bool"}],
                    :payable false,
                    :stateMutability "nonpayable",
                    :type "function",
                    :signature "0xa9059cbb"}
                   {:constant false,
                    :inputs [],
                    :name "deposit",
                    :outputs [],
                    :payable true,
                    :stateMutability "payable",
                    :type "function",
                    :signature "0xd0e30db0"}
                   {:constant true,
                    :inputs [{:name "", :type "address"} {:name "", :type "address"}],
                    :name "allowance",
                    :outputs [{:name "", :type "uint256"}],
                    :payable false,
                    :stateMutability "view",
                    :type "function",
                    :signature "0xdd62ed3e"}
                   {:payable true, :stateMutability "payable", :type "fallback"}
                   {:anonymous false,
                    :inputs [{:indexed true, :name "src", :type "address"}
                             {:indexed true, :name "guy", :type "address"}
                             {:indexed false, :name "wad", :type "uint256"}],
                    :name "Approval",
                    :type "event",
                    :signature "0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"}
                   {:anonymous false,
                    :inputs [{:indexed true, :name "src", :type "address"}
                             {:indexed true, :name "dst", :type "address"}
                             {:indexed false, :name "wad", :type "uint256"}],
                    :name "Transfer",
                    :type "event",
                    :signature "0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"}
                   {:anonymous false,
                    :inputs [{:indexed true, :name "dst", :type "address"}
                             {:indexed false, :name "wad", :type "uint256"}],
                    :name "Deposit",
                    :type "event",
                    :signature "0xe1fffcc4923d04b559f4d29a8bfc6cda04eb5b0d3c460751c2402c5c5cc9109c"}
                   {:anonymous false,
                    :inputs [{:indexed true, :name "src", :type "address"}
                             {:indexed false, :name "wad", :type "uint256"}],
                    :name "Withdrawal",
                    :type "event",
                    :signature "0x7fcf532c15f0a6db0bd6d0e038bea71d30d808c7d98cb3bf7268a95bf5081b65"}]})

(def a-block
  {:transactionsRoot "0x092e64900d71226ec63f46d2c0d5a99e7f3b35690a390893e9573aeb69d72b80",
   :logsBloom "0x00080000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000010000000000000000000000000000000000000000000000100000000000000400000000000",
   :mixHash "0x0000000000000000000000000000000000000000000000000000000000000000",
   :hash "0x4fdb9998652b1624e3fa4e1f0fa4c2b55bed952d43f155a5944b6aa4597c82e0",
   :number "0x2a87c8",
   :stateRoot "0x584fd88f4a6cd81750281fa08703c9d99cf7bacb1296d77636a4eaa7ce56c626",
   :difficulty "0x2",
   :receiptsRoot "0x35a4e16edc2e43493af075951b9dbb8465f52a0100efcd4190464cae2c1bd818",
   :uncles [],
   :parentHash "0x58249f6d223c4b1f51197d51524fd11e5ae34c0a2e23ef8d78599ce3b905c50d",
   :size "0x13f5",
   :sha3Uncles "0x1dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413f0a142fd40d49347",
   :gasUsed "0x11bd93",
   :transactions [{:r "0x2767e0fd9a1e69d4cc720e3f92e26d44d18de14a65df29e59eab84ad89303e13",
                   :blockHash "0x4fdb9998652b1624e3fa4e1f0fa4c2b55bed952d43f155a5944b6aa4597c82e0",
                   :v "0x2c",
                   :hash "0xbcefb2f6345f44f06d7939f69e76c1f8c055c4f530cb47de86f2141da6009fef",
                   :gasPrice "0x174876e800",
                   :value "0x0",
                   :gas "0x47e7c4",
                   :transactionIndex "0x0",
                   :s "0x5901233fc853bf7791c08db89d49879d640c7e49c731e8e0e6f3db0f9f1d65ee",
                   :blockNumber "0x2a87c8",
                   :from "0x6285d98c077e268242570d635ac9cd1430ad48af",
                   :input "0xfdacd5760000000000000000000000000000000000000000000000000000000000000002",
                   :nonce "0xa0",
                   :to "0xe64a27842ee1b3a3f615bed14936c66138377695"}
                  {:r "0xfe9f514b94f1211e9e13a49336721365205a665cf7a80b993678b80a9de9c17f",
                   :blockHash "0x4fdb9998652b1624e3fa4e1f0fa4c2b55bed952d43f155a5944b6aa4597c82e0",
                   :v "0x2c",
                   :hash "0x1a8b855b28e164d199075ae8c1afa49424cb11e39e478a4f345393c96ab1541f",
                   :gasPrice "0x7aef40a00",
                   :value "0x0",
                   :gas "0x8ae57",
                   :transactionIndex "0x1",
                   :s "0x4a2a3a81f84f978f3a6e518901a5b07b30f5f4132d93be0cb5cfdc5b1d5a25d0",
                   :blockNumber "0x2a87c8",
                   :from "0x8ad61b700fc2cc9524173d948d1768f7188305c5",
                   :input "0x608060405234801561001057600080fd5b5060006002819055600381905560048054600160a060020a03191633179055600580546001810182559152437f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db090910155610676806100706000396000f3006080604052600436106100a35763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166303d3401f81146100a85780635bc60cfc146100d25780636857ab40146100ea57806374f3d767146100ff578063b5623cfd14610117578063d96a094a1461012c578063e2b0caef14610139578063e659c16c1461014e578063efbe1c1c14610163578063fd2b992f14610178575b600080fd5b3480156100b457600080fd5b506100c06004356101e0565b60408051918252519081900360200190f35b3480156100de57600080fd5b506100c06004356101ff565b3480156100f657600080fd5b506100c061020d565b34801561010b57600080fd5b506100c0600435610213565b34801561012357600080fd5b506100c0610221565b6101376004356102c3565b005b34801561014557600080fd5b506100c0610362565b34801561015a57600080fd5b506100c0610385565b34801561016f57600080fd5b5061013761038b565b34801561018457600080fd5b506101906004356105c5565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156101cc5781810151838201526020016101b4565b505050509050019250505060405180910390f35b60058054829081106101ee57fe5b600091825260209091200154905081565b60078054829081106101ee57fe5b60025481565b60068054829081106101ee57fe5b600080602d6002600660025481548110151561023957fe5b600091825260209091200154034081151561025057fe5b06602d6001600660025481548110151561026657fe5b600091825260209091200154034081151561027d57fe5b06606402602d600660025481548110151561029457fe5b600091825260209091200154408115156102aa57fe5b0661271002600254620f42400201010190508091505090565b600254620f424002810160008181526001602081815260408084208054808501825590855282852001805473ffffffffffffffffffffffffffffffffffffffff191633908117909155808552848352818520805494850181558552938290209092018490558151928352820184905280517f4b07954869cc0f3266dc7593b42dc1bb5af7404a0a06cdb673d7d22b815107049281900390910190a15050565b6000600560025481548110151561037557fe5b9060005260206000200154905090565b60035481565b600680546001810182556000828152437ff652222313e28459528d920b65115c16c04f3efc82aaedc97be59f3f377c0d3f909201919091556002805483549293602d9390919081106103d957fe5b60009182526020909120015403408115156103f057fe5b06602d6001600660025481548110151561040657fe5b600091825260209091200154034081151561041d57fe5b06606402602d600660025481548110151561043457fe5b6000918252602090912001544081151561044a57fe5b600254600780546001810182556000919091529290910661271002620f42409091020191909101919091017fa66cc928b5edb82af9bd49922954155ab7b0942694bea4ce44661d9a8736c68890910181905560045490915073ffffffffffffffffffffffffffffffffffffffff166108fc600a3031049081150290604051600060405180830381858888f193505050501580156104eb573d6000803e3d6000fd5b506002805460010190819055600580547f10290dd180b2668ef7ad64a60e84ab7f7c959a75cb70f44d20ca6a16a1dc0ba09290811061052657fe5b9060005260206000200154600660025481548110151561054257fe5b9060005260206000200154600760025481548110151561055e57fe5b906000526020600020015460405180848152602001838152602001828152602001935050505060405180910390a15060058054600181018255600091909152437f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db090910155565b600254620f42400281016000818152600160209081526040918290208054835181840281018401909452808452606094939283018282801561063d57602002820191906000526020600020905b815473ffffffffffffffffffffffffffffffffffffffff168152600190910190602001808311610612575b50505050509150509190505600a165627a7a7230582023d2368fb1a417c11392b523e1853eb2fcca92a5488eabd10c9529ace659d76c0029",
                   :nonce "0x21",
                   :to nil}
                  {:r "0xaf6c84f04dbfcabb4394ed91a2773d403d20bbe7b887fe59847c0ea01210634e",
                   :blockHash "0x4fdb9998652b1624e3fa4e1f0fa4c2b55bed952d43f155a5944b6aa4597c82e0",
                   :v "0x2b",
                   :hash "0x64a7ef80275a36a1fc1ce00f78d6c4a1786e65e5d8746a42e2778630f1fb0e87",
                   :gasPrice "0x2540be400",
                   :value "0x2386f26fc10000",
                   :gas "0x5f46d",
                   :transactionIndex "0x2",
                   :s "0x57e86ae3b83d25e1d900f573420927e1adb8cb1d1c82d11320fe4b7148f201da",
                   :blockNumber "0x2a87c8",
                   :from "0x925b35f5bfc2bafa67a06358944a3c2b45ce9e9f",
                   :input "0x",
                   :nonce "0x35",
                   :to "0xf7d65e949d527dabf715678575a1b9cef50621e6"}
                  {:r "0xa82db6d412fe533cf7f891965566e0146f631c8b3532dc5b9e9cf23e4308a8ac",
                   :blockHash "0x4fdb9998652b1624e3fa4e1f0fa4c2b55bed952d43f155a5944b6aa4597c82e0",
                   :v "0x2b",
                   :hash "0xa2ce30c25ff51c056f19ae49ced2ff77a05bb2d82e040acf43270ead8338de4a",
                   :gasPrice "0x2540be400",
                   :value "0x0",
                   :gas "0x124f80",
                   :transactionIndex "0x3",
                   :s "0x6542aaa19520219f9f165506ae20ce892097c3940245f11ca8733611d19a45cc",
                   :blockNumber "0x2a87c8",
                   :from "0x674647242239941b2d35368e66a4edc39b161da9",
                   :input "0x4a46d88b000000000000000000000000000000000000000000000000000000000000004000000000000000000000000000000000000000000000000000000000000003800000000000000000000000000000000000000000000000000000000000000019000000000000000000000000ffa9c744b0001b4e69fec73f09ced34836387c51000000000000000000000000875abbcba7b2432bc07b03e282a1465979ef37d70000000000000000000000005722474235cb81f640577725c33bef2563176a53000000000000000000000000ecdc2b116730956d148e3af139eb565ea438c847000000000000000000000000cd5f99f875bc2224ca0d0d4f208338ed55c20ad4000000000000000000000000b7b283ceff8ef791605ed67361db862b8082f0c2000000000000000000000000e755269ca9f375506fc30d01910537449698e6620000000000000000000000006e382bf7151d3ccd31f6e947d54b570c3406a6d3000000000000000000000000d7cf37924617bce1569fe6b33414f6b2514aabd0000000000000000000000000da8bc98b76dcdf8722c5e7385cfa6bdb280b4ce2000000000000000000000000c83d9cb7c365ba2851df383498d1c8cb94e043d40000000000000000000000000796cb7b450e5630d0ea250cde30744260a8a16c000000000000000000000000d87fea54f506972e3267239ec8e159548892074a0000000000000000000000007dfe30762f1767a69b83f8080d094cc0414eeed500000000000000000000000086a6a508104f199870a7bc0594c967f589da372f000000000000000000000000e76f55f4ac344396f90207181609d182bf165e34000000000000000000000000489a1dcf2e0c489b08d7036dfe02f7e251b8ae8b00000000000000000000000037a048462f2f1a4f50b8670e6816e53b16f8510a0000000000000000000000007ae106888cac45503e76a4e06189d95d6c0989450000000000000000000000008aa852b299c748a5ab8bd2764309f8c3c756bd3b0000000000000000000000007287345c6c01226eeaf972a4d7cea8a2ac6a0dd8000000000000000000000000e96376289786c14c790af049010ce81ac3a9c1210000000000000000000000002fa877029e21a3ce42c6c0320ccbd882504efea20000000000000000000000006546b35d70c1703b54029f72f0ece1ddbd8a0c7d0000000000000000000000006f2d6ff85efca691aad23d549771160a12f0a0fc000000000000000000000000000000000000000000000000000000000000001900000000000000000000000000000000000000000000000002a19832096a00000000000000000000000000000000000000000000000000001158e460913d0000000000000000000000000000000000000000000000000000017a023c7c1a00000000000000000000000000000000000000000000000000000357d9460e644000000000000000000000000000000000000000000000000000000c42aa8d1eb000000000000000000000000000000000000000000000000000027b949a265140000000000000000000000000000000000000000000000000000024fbd7001ca00000000000000000000000000000000000000000000000000006b94a2ed9ad4000000000000000000000000000000000000000000000000000009cf579d62d4000000000000000000000000000000000000000000000000000003c25becc0c200000000000000000000000000000000000000000000000000007b3c18f3a57803c0000000000000000000000000000000000000000000000000108371ef7f22000000000000000000000000000000000000000000000000000042093b96c338000000000000000000000000000000000000000000000000000013321d124d520000000000000000000000000000000000000000000000000000325c165fb0f000000000000000000000000000000000000000000000000000040aba54f6d520000000000000000000000000000000000000000000000000000002355d594efa00000000000000000000000000000000000000000000000000003660f40a17e4000000000000000000000000000000000000000000000000000006438d8751d200000000000000000000000000000000000000000000000000006c6145d2ade400000000000000000000000000000000000000000000000000000a2927a40ec000000000000000000000000000000000000000000000000000000a249b7cd5700000000000000000000000000000000000000000000000000000021c3d66ff2000000000000000000000000000000000000000000000000000000904facbec6c0000000000000000000000000000000000000000000000000000de0b6b3a7640000",
                   :nonce "0x5a25",
                   :to "0x97e3ba6cc43b2af2241d4cad4520da8266170988"}
                  {:r "0xd75bf4ae5d9040b448fc8f1950955b98e1a9947d5c6fc3df2da44ee62bd8320",
                   :blockHash "0x4fdb9998652b1624e3fa4e1f0fa4c2b55bed952d43f155a5944b6aa4597c82e0",
                   :v "0x2c",
                   :hash "0xb6aa8c99f814cdd303818dd4e3b184f8e43f3542bd07312c63bd7a96057d6b82",
                   :gasPrice "0x2540be400",
                   :value "0x0",
                   :gas "0x366ea",
                   :transactionIndex "0x4",
                   :s "0x7d3a4f442509b6885d4fec8aec1ff4789354411e6c0e66e10df835bbfd59f5d1",
                   :blockNumber "0x2a87c8",
                   :from "0x007b751e4aa185b0d55f14b330a92582259f892b",
                   :input "0xdc9bb818000000000000000000000000c0280ffce9e446585a7a7a6e28fe723ea9276d9c0000000000000000000000000000000000000000000000000000000000000001",
                   :nonce "0x36fb",
                   :to "0xf60b63a2cd2c49280373af1c659dfb1b2b3e94da"}
                  {:r "0x13ab6ea4ca717d4a6715cf5d2f25ae79a92b1447ae4d27a58f3a1ffb45378ddd",
                   :blockHash "0x4fdb9998652b1624e3fa4e1f0fa4c2b55bed952d43f155a5944b6aa4597c82e0",
                   :v "0x2b",
                   :hash "0x571e082ac20b58a36a684965b7ddb5a7a19da4bc97c7b07fcc1b640e8be14c55",
                   :gasPrice "0x2540be400",
                   :value "0x0",
                   :gas "0x366ea",
                   :transactionIndex "0x5",
                   :s "0x62f82245c281f02f420233a8735d54056e923779a43bbecd98153266b25fcfd0",
                   :blockNumber "0x2a87c8",
                   :from "0x007b751e4aa185b0d55f14b330a92582259f892b",
                   :input "0xb23c5f02000000000000000000000000c0280ffce9e446585a7a7a6e28fe723ea9276d9c0000000000000000000000000000000000000000000000000000000000000001",
                   :nonce "0x36fc",
                   :to "0x8688ba68b327d313d279377230951e45707a1124"}
                  {:r "0xb676e4186f6c17be7844ebe6e204096d81ec42d946298f89084dc1676c2ef607",
                   :blockHash "0x4fdb9998652b1624e3fa4e1f0fa4c2b55bed952d43f155a5944b6aa4597c82e0",
                   :v "0x2c",
                   :hash "0x5d26cdad2d1ad902b9d5c4e5ad4f110b63ab7c4771abf642e4fb2e5aedd48cc3",
                   :gasPrice "0x3b9aca00",
                   :value "0x0",
                   :gas "0x3d0900",
                   :transactionIndex "0x6",
                   :s "0x357d3f3331d6108585bd493124fa0540d90572e1e11ecbb9eef301de7fcc94e4",
                   :blockNumber "0x2a87c8",
                   :from "0xd4cbde2badfc4dd3d6464dc8917b01feb9976a0f",
                   :input "0x9ed26fe8000000000000000000000000000000000000000000000000000000000000002000000000000000000000000000000000000000000000000000000000000000093336312e30303030300000000000000000000000000000000000000000000000",
                   :nonce "0x1c6",
                   :to "0xd28bf1d1959f3d174d1a50f1ef6d8ac953f7244c"}],
   :miner "0x0000000000000000000000000000000000000000",
   :timestamp "0x5b6d2394",
   :nonce "0x0000000000000000",
   :gasLimit "0x6af5b7",
   :totalDifficulty "0x504c67",
   :extraData "0xd68301080e846765746886676f312e3130856c696e7578000000000000000000a86ff1b94be34f5d68b6ffc214c44acd2fd0b1f11dba97b67ebf5b10258275fd6d29f27c6f8133f12d98f4eaa388500ac8473c6d7a2f1f5bf50340ab44e7037001"})

(def events
  [{:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xf4ea8cf3c1efe517b928954791bd079b2bdef5044aa9eb98603f3ee6eb320881",
    :blockHash "0xa348b8eae8dbd91128a60c3355384ca56bd01abe38718309a21dad36fcb7d235",
    :transactionIndex "0x7",
    :topics ["0xce241d7ca1f669fee44b6fc00b8eba2df3bb514eed0f6f668f8f89096e81ed94"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"],
    :blockNumber "0x263c1e",
    :logIndex "0xb",
    :removed false,
    :data "0x"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xf4ea8cf3c1efe517b928954791bd079b2bdef5044aa9eb98603f3ee6eb320881",
    :blockHash "0xa348b8eae8dbd91128a60c3355384ca56bd01abe38718309a21dad36fcb7d235",
    :transactionIndex "0x7",
    :topics ["0x0f6798a560793a54c3bcfe86a93cde1e73087d944c0ea20544137d4121396885"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"],
    :blockNumber "0x263c1e",
    :logIndex "0xc",
    :removed false,
    :data "0x00000000000000000000000000000000000000000052b7d2dcc80cd2e4000000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x93868d03131c5a370f0535033b5d867c2bc3e0d760a6206376b230abba096d46",
    :blockHash "0xecc749c03f5354099132caf15bb364af163ad0f06487fd1ad22132ca88eac5d7",
    :transactionIndex "0x5",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x000000000000000000000000ebcbdc877c0e07c1a1e1b15e2d75c732e22e546f"],
    :blockNumber "0x263c41",
    :logIndex "0x3",
    :removed false,
    :data "0x00000000000000000000000000000000000000000000021e19e0c9bab2400000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xea9c066a3bf67b3371f5094f94fc2c32a4adeca1be84ca1a1a8c7328666a7a1f",
    :blockHash "0xc1c64dd64f1f8829d3fa94eb39116c0485637f3f3bb4081a4c0f943f6e69dffa",
    :transactionIndex "0xb",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x000000000000000000000000ebcbdc877c0e07c1a1e1b15e2d75c732e22e546f"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x263c48",
    :logIndex "0x10",
    :removed false,
    :data "0x0000000000000000000000000000000000000000000001e7e4171bf4d3a00000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xe3cb1de162fc6fd16700949da4b20dab59c2dda20919fe49f2af61596579d0ba",
    :blockHash "0x24e8fe6239704f938b4b18c6476488d5f166495d66a0f16bb732785c1ac427c9",
    :transactionIndex "0x9",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x263c8b",
    :logIndex "0xa",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x73135ca21ae0ee45d1666bf9b205e80be578ddfef5b33cf7d876e30277ee3d36",
    :blockHash "0x63f53caabfeb25fce3e40d6b0b8ecc9909d5dc6613eb3d8cd445167f1e66e23f",
    :transactionIndex "0xe",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x000000000000000000000000f01171c1273e826c27f5e058af0d146733a7133c"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x263e40",
    :logIndex "0x17",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xac6c65e7d9b12e563ad42babdd5bf5577cf791a8bda6b78bd7a4fa61c24a6716",
    :blockHash "0x97687177de29ad32ead32b23a4ff3f127f83ad22d74c79db29b021a72c671de9",
    :transactionIndex "0x3",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x000000000000000000000000bcd1e9e7098fbd0fc36013a8408eb67053d3006b"],
    :blockNumber "0x263f51",
    :logIndex "0x1",
    :removed false,
    :data "0x00000000000000000000000000000000000000000000000393ef1a5127c80000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xda83d0059618cc7e749672b79fe4653067c2cea61fad0f07a61cbe8338d40598",
    :blockHash "0xe7f0be885ce0bb2c5d10b4a08f3ed30a1f87a75b04876ade160aaab5d8b5b13c",
    :transactionIndex "0xc",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x000000000000000000000000bcd1e9e7098fbd0fc36013a8408eb67053d3006b"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x263f56",
    :logIndex "0x10",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x997796069f47be6594ccb8864b86599f10356576ae5e59237ee03d9079525715",
    :blockHash "0x8ff0ce2246acb64d8f4632ded5bb592953313f2a4e553847a9a6d4aad21d9897",
    :transactionIndex "0xe",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x000000000000000000000000eca052db10bcf29b1e77935792f1cc269570ffa6"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x26442d",
    :logIndex "0x13",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xf625340c62f9ed48cecacb0269901e9894087d6647f387c255b7f204353ccb6e",
    :blockHash "0xf9c1f8f83eede5d65b6ef5971e104d8c5ecddbe075676242d9ed218df41d8daf",
    :transactionIndex "0xb",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x000000000000000000000000eca052db10bcf29b1e77935792f1cc269570ffa6"],
    :blockNumber "0x264449",
    :logIndex "0x13",
    :removed false,
    :data "0x0000000000000000000000000000000000000000000000056bc75e2d63100000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x7cf15b31d0bce54fd45d8fa4558f1ba6eb8735962fe95559066e5cee3241a1bb",
    :blockHash "0xec3e4d00d179a4b78d1d0bea18693803202b69436aec647fe5e06a116ce83dce",
    :transactionIndex "0x2",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x000000000000000000000000fa9352485d1aad4f4816245cd60495ae1ccaddaf"],
    :blockNumber "0x265d9b",
    :logIndex "0x1",
    :removed false,
    :data "0x000000000000000000000000000000000000000000000042e530adfce0080000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xa89df970aced6e3b808ff338401ffab82f530fc65ea15839117b672e28c7669c",
    :blockHash "0x70cdeba4fcaddce09d292c563c37308ac59330ae238d1bb7ede09d34c3aa803d",
    :transactionIndex "0x13",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x0000000000000000000000006c2ecd6388c550e8d99ada34a1cd55bedd052ad9"],
    :blockNumber "0x267704",
    :logIndex "0x8",
    :removed false,
    :data "0x00000000000000000000000000000000000000000000003635c9adc5dea00000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x8de63afdd80e5a76b625f04acaed25df00b81f1dd2b29b9c2537411fbc30801e",
    :blockHash "0x3418269b73d640a09a9b3a88774ccd766437d83d2bf6e479c2d873e7b8377ffc",
    :transactionIndex "0x13",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x000000000000000000000000cef6a7c0bd8deec9460de9d2130e8f240cfa75d6"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x267862",
    :logIndex "0x2",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x02977666546b491d99f8fa21733e958e6a42dbabd58d3da0787be080d5135593",
    :blockHash "0xb3dd52af0b76098b53cfc036112245acc0ddd288f59febe7538db9db3b9c863f",
    :transactionIndex "0xc",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x00000000000000000000000085a8b64b4bf4045dd24eac297926770df8e54fb0"],
    :blockNumber "0x267939",
    :logIndex "0x6",
    :removed false,
    :data "0x0000000000000000000000000000000000000000000000056bc75e2d63100000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x0915aadbe8d4b747fcfe6e0aa994ef9059021331b61aabb0391ad9cc08cf24ab",
    :blockHash "0xd73ba829200c19934f04b5b967cdc6918d5dfd4e814e2e0a8419219c8940949b",
    :transactionIndex "0xd",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x000000000000000000000000c43670cede984fbeb4f37dfa177d048628722414"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x26940e",
    :logIndex "0x17",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x1686e363941585d8a3ef8d94c3a941a77080ca68e7ec6beb4143ee1f2055e5ab",
    :blockHash "0x1f1795868f3db1ae25b9940b57e0e47626dde6377ddb84d2e1bb25ab6330993b",
    :transactionIndex "0x4",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x000000000000000000000000cef6a7c0bd8deec9460de9d2130e8f240cfa75d6"],
    :blockNumber "0x269450",
    :logIndex "0x6",
    :removed false,
    :data "0x000000000000000000000000000000000000000000000001158e460913d00000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x0fe54fb5dbf676200f69870d2f5f64daf65793684e861855ea8f4977b9d978f8",
    :blockHash "0xdfc3995c95e3a7860c391cafe608bd0bd9cef00279506739164411625f29673a",
    :transactionIndex "0xc",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x000000000000000000000000cef6a7c0bd8deec9460de9d2130e8f240cfa75d6"],
    :blockNumber "0x2695be",
    :logIndex "0x10",
    :removed false,
    :data "0x000000000000000000000000000000000000000000000000a688906bd8b00000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xcc952f07d88af80549346c6d540b74957400464b98c30d77eaab7fcf677c3209",
    :blockHash "0xdfc3995c95e3a7860c391cafe608bd0bd9cef00279506739164411625f29673a",
    :transactionIndex "0xd",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x000000000000000000000000cef6a7c0bd8deec9460de9d2130e8f240cfa75d6"],
    :blockNumber "0x2695be",
    :logIndex "0x13",
    :removed false,
    :data "0x000000000000000000000000000000000000000000000000a688906bd8b00000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x35f0be0f54800858c700031b8432486036a49eb5211d3e9389382946c7987de7",
    :blockHash "0xdfc3995c95e3a7860c391cafe608bd0bd9cef00279506739164411625f29673a",
    :transactionIndex "0xe",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x000000000000000000000000cef6a7c0bd8deec9460de9d2130e8f240cfa75d6"],
    :blockNumber "0x2695be",
    :logIndex "0x16",
    :removed false,
    :data "0x000000000000000000000000000000000000000000000000a688906bd8b00000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x8d208f7a09a2d25817051600b25934c5708db347c5e9216a65a83fb0ae154911",
    :blockHash "0xcdb4b0aa1dc37cf0c90e536589c9cd4004d644fa4f65367e6b3829d0bc576421",
    :transactionIndex "0x0",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x000000000000000000000000901e9ffe28c136759399025ef9d2da2ca9089bd2"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x26cf9f",
    :logIndex "0x0",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xc9a4c5d001edaf251a78e1568dc06bef1368dea9a3fc97b6b7c4ccc3101da225",
    :blockHash "0xba905caaa6be7f89c6067980abbaffb826322b6078e7b284760a944d124007e5",
    :transactionIndex "0x3",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x0000000000000000000000006c2ecd6388c550e8d99ada34a1cd55bedd052ad9"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x26d933",
    :logIndex "0x2",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x8f5e9485ff37bac6d4a427644925878e9a077db677c1cf17758d9cc1fe776db1",
    :blockHash "0x813a6d0aed96cc3d7df5e996391d4d212033d65d09edddf8ed7aa6ae2e8ae935",
    :transactionIndex "0x4",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x0000000000000000000000006c2ecd6388c550e8d99ada34a1cd55bedd052ad9"
             "0x000000000000000000000000cef6a7c0bd8deec9460de9d2130e8f240cfa75d6"],
    :blockNumber "0x26d936",
    :logIndex "0x6",
    :removed false,
    :data "0x0000000000000000000000000000000000000000000000000de0b6b3a7640000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x3f0d5c6f8f7993229f9af858adaba9ea735b3067a1c5f4c07290bd12020d36a7",
    :blockHash "0xced3346465de847783ce93a1567bdc5576c045692eaa95d0f16ac28196660e62",
    :transactionIndex "0x8",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x000000000000000000000000cef6a7c0bd8deec9460de9d2130e8f240cfa75d6"
             "0x0000000000000000000000006c2ecd6388c550e8d99ada34a1cd55bedd052ad9"],
    :blockNumber "0x26d96e",
    :logIndex "0xb",
    :removed false,
    :data "0x0000000000000000000000000000000000000000000000000de0b6b3a7640000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x34a99963fef30cc11e12b0853d971289c7a75237d2713c96c8f774d8cd7b5359",
    :blockHash "0x7d5d495c2118147551563581f28ae950ecec114885a1d0982599f28caaf57a60",
    :transactionIndex "0xd",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x00000000000000000000000057d7cf57669054ebc6787277fe72ae9ee76571e3"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x26f204",
    :logIndex "0x10",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xf1fec41c0b249400e547d5580218a149db9921edad4f30443b8d23a9b76aba36",
    :blockHash "0x7d5d495c2118147551563581f28ae950ecec114885a1d0982599f28caaf57a60",
    :transactionIndex "0xe",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x00000000000000000000000057d7cf57669054ebc6787277fe72ae9ee76571e3"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x26f204",
    :logIndex "0x11",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x4ede05ce3b46c1b14873fbe4a128497e3caf9b1be650948d03743c226d7f036b",
    :blockHash "0x876b1823549a5fad0b2ed11778c4900555bb81c649a03035158b859682d812b2",
    :transactionIndex "0x6",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x000000000000000000000000e9a337482087b71ae0a3b3146cd9bb3f934ef471"],
    :blockNumber "0x274323",
    :logIndex "0xd",
    :removed false,
    :data "0x000000000000000000000000000000000000000000000000016345785d8a0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xfd9a8bfd0502b6eb821d67944a4d74cbd8824f8ddc9fd642fc706550c6729a16",
    :blockHash "0x6048539786eb9b13347e84c7c4c76e22c2767deb207a0d527861df01ffa4f7ae",
    :transactionIndex "0x5",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x000000000000000000000000cef6a7c0bd8deec9460de9d2130e8f240cfa75d6"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"],
    :blockNumber "0x2759b7",
    :logIndex "0x18",
    :removed false,
    :data "0x000000000000000000000000000000000000000000000000016345785d8a0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xe569017199d5cde92cfaf6609f705d6af84a25aa0ca62c6a23585ec04f4995ad",
    :blockHash "0x9836ee11528229ec22bb965132681cb276e091a69c04000216b5ad0ff2df29d5",
    :transactionIndex "0x2",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x0000000000000000000000001da8f44a3466527de71f8dc10ef6f39bd4921eae"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x27a6dd",
    :logIndex "0x2",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xd9866393a0186bda6fd0c2426da886ba7fe80a042599051d9e668743f962848a",
    :blockHash "0x94a5a6b290fb94afe6bc72adea56721c9b1d145bd2fac24d066336ee7012a67e",
    :transactionIndex "0xf",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x0000000000000000000000001da8f44a3466527de71f8dc10ef6f39bd4921eae"],
    :blockNumber "0x27a6ef",
    :logIndex "0x1d",
    :removed false,
    :data "0x0000000000000000000000000000000000000000000000008ac7230489e80000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xe002f2263689bd60dec5bbe67c241d0b8e014c27ac726c924c30e5ab69f0f477",
    :blockHash "0xa59c1b57067dcc8a8db3e3cf069831b5dc5e8361bde6ce26082b4e97468bea9d",
    :transactionIndex "0x5",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x000000000000000000000000cef6a7c0bd8deec9460de9d2130e8f240cfa75d6"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"],
    :blockNumber "0x27cab5",
    :logIndex "0xa",
    :removed false,
    :data "0x000000000000000000000000000000000000000000000000016345785d8a0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x77ea5368a7e00a836f94679f4a1fb902f2365a33acdb251d99bfd0c0e970ce95",
    :blockHash "0x300abb5fbc265af5e976d82d3ef28209308e76bba1cb6400c4a9f558fd6d1fbc",
    :transactionIndex "0x8",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x0000000000000000000000006928c5d01f2c42abcf72444c243ee61c6837f9a8"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x27d3c0",
    :logIndex "0xb",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x3518bec985f83da0e3e60d12d58387dda54897a439cf731536ffa18f518d7bad",
    :blockHash "0x300abb5fbc265af5e976d82d3ef28209308e76bba1cb6400c4a9f558fd6d1fbc",
    :transactionIndex "0xa",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x0000000000000000000000006928c5d01f2c42abcf72444c243ee61c6837f9a8"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x27d3c0",
    :logIndex "0xd",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x0f9bbebf8a97bdace51ff59193b74a402bf04a30e63aa4591ab1a51f8aa5abcd",
    :blockHash "0x960f52685ffa5377cde2522329531379f1482523cd30e6849b8dc7b999cc2e9e",
    :transactionIndex "0xa",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x0000000000000000000000006928c5d01f2c42abcf72444c243ee61c6837f9a8"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x27d3c2",
    :logIndex "0x16",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x524fa298175779926fbb410e15ca384aa9921d3821661c66ada3ca1c03557e24",
    :blockHash "0xcd64990e0fdb176778e863aa6119494a55e155fe0b7cde2fa9089dfd4959b262",
    :transactionIndex "0x7",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"
             "0x0000000000000000000000006928c5d01f2c42abcf72444c243ee61c6837f9a8"],
    :blockNumber "0x27d3d8",
    :logIndex "0xa",
    :removed false,
    :data "0x00000000000000000000000000000000000000000000021b9a1caffa40be0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x77eefae0d26750cb9ad54d27d3ad8a124876505964ef3ef1a24e52a4d5a27fab",
    :blockHash "0x3f164d212e8e66defdf6330b362dac2543f2fd03053536142cb88367c6956466",
    :transactionIndex "0x1b",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x000000000000000000000000cef6a7c0bd8deec9460de9d2130e8f240cfa75d6"
             "0x0000000000000000000000006928c5d01f2c42abcf72444c243ee61c6837f9a8"],
    :blockNumber "0x27e087",
    :logIndex "0x17",
    :removed false,
    :data "0x000000000000000000000000000000000000000000000000016345785d8a0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xf63ec2f02f4c93ed263cbc41f75b9a5f7e9c61bb76e97e14b617b616ddbfc8e0",
    :blockHash "0xbd3dbc3869f1a30b79dfb60d05080fb3cac963cfc81d7edd7af52ee7a2382415",
    :transactionIndex "0x4",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x000000000000000000000000cef6a7c0bd8deec9460de9d2130e8f240cfa75d6"
             "0x00000000000000000000000029a6feab1ff84f69e2b70f7b4aa1149706a35658"],
    :blockNumber "0x27ff52",
    :logIndex "0x5",
    :removed false,
    :data "0x000000000000000000000000000000000000000000000000002386f26fc10000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xec9b031e208f17f68ad7cf6a9aa9702aae0ab8b57e50ebe14095ec223f1871a4",
    :blockHash "0xdfbd85bdaacebe4de1c9b3d479995ff3475ff37901ca682236c216148ee0bf54",
    :transactionIndex "0x0",
    :topics ["0xddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef"
             "0x000000000000000000000000cef6a7c0bd8deec9460de9d2130e8f240cfa75d6"
             "0x00000000000000000000000060a2891f7a88f9c935ca8bbcf137e3268f7d1227"],
    :blockNumber "0x28104e",
    :logIndex "0x0",
    :removed false,
    :data "0x0000000000000000000000000000000000000000000000008ac7230489e80000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0xe4afa29105f82a2a46b6e814812365ee58cb4626c5770b9674397c1e564239e4",
    :blockHash "0x408fbc53ab13be9801eaed4fd68d263df51e15e43ddb68bf9d643d85dc17ff07",
    :transactionIndex "0xd",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x0000000000000000000000005b112402b7cf9cd167ad1a5b19f55b8ae87fc144"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x28160b",
    :logIndex "0xb",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x464942e77c4e23d1a067994ee0fa81988b1d817ca7698f707a777d22ff797f86",
    :blockHash "0x4941bf3ecb02d1196bfd1d266fb9919b6260b0aff54381ff807c24028e28649b",
    :transactionIndex "0x1f",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x00000000000000000000000096307625d4df4e894e5d1b9671d6535f9296d3c9"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x2817d8",
    :logIndex "0x25",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}
   {:address "0x475cda4a73ee3f01748a9d553a8c19ca2853a8aa",
    :transactionHash "0x50531ee5774338d1b45ae3b35641dd29329dc40f42585890523f1f24d7c1633c",
    :blockHash "0xb440211271fd45e12df40e2d44259b5139b1012e646b780a4579745b84c4225f",
    :transactionIndex "0x7",
    :topics ["0x8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925"
             "0x0000000000000000000000007d185d0742b56231ab3271a1a375b1ab5ab59e4e"
             "0x000000000000000000000000f2dbcda947fcef23da4617adb22952afc2f9350b"],
    :blockNumber "0x2949d3",
    :logIndex "0x6",
    :removed false,
    :data "0xfffffffffffffffffffffffffffffffffffffffffffffffff21f494c589c0000"}])

(def example-state
  {:contracts {:oax oax-contract,
               :weth weth-contract},
   :block a-block,
   :events events})
