def solution(bridge_length, weight, truck_weights):
    bridge = [0] * bridge_length
    answer =0
    weight_on_bridge = 0
    while truck_weights :
        answer +=1

        if bridge[0]!=0 :
            weight_on_bridge -= bridge[0]
        bridge.pop(0)
        incomming_weight = truck_weights[0]

        if weight_on_bridge + incomming_weight <= weight :
            bridge.append(truck_weights.pop(0))
            weight_on_bridge += incomming_weight
        else: bridge.append(0)

    return answer + bridge_length